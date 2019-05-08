package com.dahnworld.app.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.HSPMemberSoapProxy;
import org.tempuri.MemberInfo;

import com.dahnworld.app.dto.UserDto;
import com.dahnworld.app.jwt.JwtProvider;
import com.dahnworld.app.response.JwtResponse;
import com.dahnworld.app.service.UserService;
import com.dahnworld.app.util.DataTableUtil;

import kr.co.br.dainnetuser.ws.wsMbrFeeGrade_asmx.WsMbrFeeGradeSoapProxy;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class testController {
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PutMapping("/test")
	protected ResponseEntity<?> test(@RequestAttribute JwtResponse jwtResponse) throws RemoteException {
		
		String accessToken = jwtResponse.getToken();

		if(accessToken == null) {
			return ResponseEntity.ok(jwtResponse);
		}
		
		String userId = jwtProvider.getUserNameFromJwtToken(accessToken);
		UserDto userDto = userService.getUserByUserId(userId);
		
		HashMap<String, UserDto> payload = new HashMap<>();
		
		payload.put("user", userDto);

		jwtResponse.setPayload(payload);
		
		System.out.println("NewMsg : " + jwtResponse.getNewMsg());
		
		
		return ResponseEntity.ok(jwtResponse);
	}
	
	@GetMapping("/ajs")
	protected void ajs() throws RemoteException {
		
		//통합회원 실섭 웹서비스(메서드 호출 시 자기 통합회원만 쓰기)
		HSPMemberSoapProxy hsp = new HSPMemberSoapProxy();
		
		String testUserId = "dkswhdgks";
		
		MemberInfo memberinfo = hsp.getTotaluser(testUserId);
		
		logger.info("email : " + memberinfo.getEmail());
		
		//다인넷 실섭 웹서비스(메서드 호출 시 자기 것만 쓰기)
		WsMbrFeeGradeSoapProxy DainMember = new WsMbrFeeGradeSoapProxy();
		
		DataTableUtil dtu = new DataTableUtil();
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		
		dtu.SetTable(DainMember.getMbrBranchGradeForMagoDb("안종한", "01043454142", "890211", "").get_any()[1].toString());

		dataList = dtu.GetDataList();
		
		if(dataList.size() > 0) {
			logger.info("keyList : " + dtu.GetKeyList());
			logger.info("gradeCd : " + dataList.get(0).get("gradeCd"));
		}
	}
}
