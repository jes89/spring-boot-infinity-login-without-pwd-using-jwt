package com.dahnworld.app.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.HSPMemberSoapProxy;
import org.tempuri.MemberInfo;

import com.dahnworld.app.dto.MessageDto;
import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.dto.UserPrinciple;
import com.dahnworld.app.jwt.JwtProvider;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;
import com.dahnworld.app.util.DataTableUtil;

import kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeSoapProxy;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("/loginByUserInfo")
	protected ResponseEntity<?> login(@RequestBody UserDto userDto) throws RemoteException {
		
		logger.info("loginByUserInfo : ");
		
		String userId = userDto.getUserId();
		String jwt = this.getJwtByUserInfo(userDto);
		HashMap<String, String> payload = new HashMap<>();
		JwtResponse jwtResponse = new JwtResponse(jwt ,"new token issued");
		UserDto selectedUserDto = userService.getUserByUserId(userId);
		
		selectedUserDto.setExpiryTime(jwtResponse.getExpiryTime());
		selectedUserDto.setMac(userDto.getMac());
		
		int updated = userService.updateUserAccessInfo(selectedUserDto, jwtResponse.getToken());
		
		logger.info("updated : " + updated);
		logger.info("jwtResponse.getToken() : " + jwtResponse.getToken());
		logger.info("selectedUserDto.toString() : " + selectedUserDto.toString());
		
		if( updated == 0) {
			jwtResponse.setMsg("update token error");
		}
		
//		this.updateDwMemberCdByUserId(userId);

		payload.put("result","success");
		
		jwtResponse.setPayload(payload);
		jwtResponse.setUserNm(selectedUserDto.getName());
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/autoLogin")
	protected ResponseEntity<?> doAutoLogin(@RequestAttribute JwtResponse jwtResponse, HttpServletRequest req) throws RemoteException {
		
		logger.info("doAutoLogin 호출 ");
		
		String msg = jwtResponse.getMsg();
		
		logger.info("msg : " + msg);
		
		if("invaild token or mac information".equals(msg) == false ) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		HashMap<String, String> payload = new HashMap<>();
		
		long expiryTime = jwtProvider.getExpiryTime(req);
		
		String accessToken = jwtProvider.getJwt(req);
		String mac = jwtProvider.getMac(req);
		String userId = userService.getUserFromTokenLog(accessToken, mac, expiryTime);
		
		logger.info("accessToken : " + accessToken);
		logger.info("mac : " + mac);
		logger.info("expiryTime : " + expiryTime);
		logger.info("userId : " + userId);
		
		if(userId == null || userId.length() == 0) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		UserDto userDto = new UserDto(userId, mac, expiryTime);
		
		UsernamePasswordAuthenticationToken authentication = this.saveUserAuthentication(userId, req);
		
		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
		
		jwtResponse = new JwtResponse(jwtProvider.generateJwtToken(authentication), "new token issued using log", userPrincipal.getUserNm());
		
		userDto.setExpiryTime(jwtResponse.getExpiryTime());
		
		int updated = userService.updateUserAccessInfo(userDto, jwtResponse.getToken());
		
		logger.info("updated : " + updated);
		logger.info("jwtResponse.getToken() : " + jwtResponse.getToken());
		logger.info("update token error : " + userDto.toString());
		
		if( updated == 0) { jwtResponse.setMsg("update token error"); } 
		
//		this.updateDwMemberCdByUserId(userId);
		
		payload.put("accessToken", accessToken);
		payload.put("mac", mac);
		payload.put("expiryTime", String.valueOf(expiryTime));
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/updateTokenLog")
	protected String doAutoLogin(@ModelAttribute UserDto userDto) {
		if(userService.updateTokenLog(userDto) > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	
	@GetMapping("/message")
	protected ResponseEntity<?> getMessage(@RequestAttribute JwtResponse jwtResponse){
		
		if(this.checkInvalidToken(jwtResponse.getToken())) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		String userId = jwtProvider.getUserNameFromJwtToken(jwtResponse.getToken());
		UserDto user = userService.getUserByUserId(userId);
		List<MessageDto> msgList = new ArrayList<>();
		MessageDto msg = new MessageDto();
		MessageDto msg2 = new MessageDto();
		
		HashMap<String, Object> payload = new HashMap<>();
		
		msg.setIdx(1);
		msg.setTitle("제목");
		msg.setContents("내용");
		msg.setWriterId("청담센터Id");
		msg.setWriterNm("청담센터");
		msg.setFilePath("/app/image/thumb_gnb_wrap_user.png");
		msg.setReadYn("N");
		msg.setRegDtm("2018-10-16");
		
		msg2.setIdx(2);
		msg2.setTitle("제목2");
		msg2.setContents("내용2");
		msg2.setWriterId("청담센터Id2");
		msg2.setWriterNm("청담센터2");
		msg2.setFilePath("/app/image/thumb_gnb_wrap_user.png");
		msg2.setReadYn("N");
		msg2.setRegDtm("2018-10-18");
		
		msgList.add(msg);
		msgList.add(msg2);
		
		payload.put("user", user);
		payload.put("msgList", msgList);
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/userInfo")
	protected ResponseEntity<?> getUserInfo(@RequestAttribute JwtResponse jwtResponse){
		if(this.checkInvalidToken(jwtResponse.getToken())) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		HashMap<String, Object> payload = new HashMap<>();
		
		String userId = jwtProvider.getUserNameFromJwtToken(jwtResponse.getToken());
		UserDto user = userService.getUserByUserId(userId);
		
		payload.put("user", user);
		
		jwtResponse.setPayload(payload);
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/list")
	protected ResponseEntity<?> getUserList(@RequestAttribute JwtResponse jwtResponse){
		List<UserDto> userList = userService.getUserByUserList();
		HashMap<String, List<UserDto>> payload = new HashMap<>();
		payload.put("userList", userList);
		jwtResponse.setPayload(payload);
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/getAttendanceList")
	protected ResponseEntity<?> getAttendanceList(@RequestAttribute JwtResponse jwtResponse){
		return ResponseEntity.ok(jwtResponse);
	}
	
	@PostMapping("/updateDainNetData")
	protected ResponseEntity<?> updateDainNetData(@RequestAttribute JwtResponse jwtResponse){
		return ResponseEntity.ok(jwtResponse);
	}
	
	@RequestMapping("/updateDwMemberCdByUserId")
	public void updateDwMemberCdByUserId() throws RemoteException {
		System.out.println("updateDwMemberCdByUserId");
		
		this.updateDwMemberCdByUserId("dkswhdgks");
	}
	
	private String getJwtByUserInfo(UserDto userDto) {

		String userId = userDto.getUserId();
		String pwd = userDto.getPwd();
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		userId,
                		pwd
                )
        );
        
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return jwtProvider.generateJwtToken(authentication);
	}
	
	private UsernamePasswordAuthenticationToken saveUserAuthentication(String userId, HttpServletRequest req) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return authentication;
	}
	
	private boolean checkInvalidToken(String token) {
		return (token == null || token.length() == 0);
	}
	
	private int updateDwMemberCdByUserId(String userId) throws RemoteException {
		
		HSPMemberSoapProxy hsp = new HSPMemberSoapProxy();
		WsMbrFeeGradeSoapProxy DainMember = new WsMbrFeeGradeSoapProxy();
		
		String userNm;
		String userHp;
		String userBirthday;
		String dwMemberCd;
		
		int result = 0;
		
		MemberInfo memberinfo = hsp.getTotaluser(userId);
		
		userNm = memberinfo.getUserNm();
		userHp = memberinfo.getHP1() + memberinfo.getHP2() + memberinfo.getHP3();
		userBirthday = memberinfo.getBirthday().substring(2);
		
		logger.info("userNm : " + userNm);
		logger.info("userHp : " + userHp);
		logger.info("userBirthday : " + userBirthday);

		DataTableUtil dtu = new DataTableUtil();
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		
		dtu.SetTable(DainMember.getMbrBranchGradeForMagoDb(userNm, userHp, userBirthday, "").get_any()[1].toString());

		dataList = dtu.GetDataList();
		
		if(dataList.size() > 0) {
			dwMemberCd = dataList.get(0).get("mbrCd");
			logger.info("dwMemberCd : " + dwMemberCd);
			
			userService.updateDwMemberCd(userId, dwMemberCd);
		}
		
		return result; 
	}
	
}
