import {user_write_form} from './template-user-write-from.js';
import {user_login_form} from './template-user-login-from.js';
import {ajaxRequest} from './request.js';
import {createInitializer} from "./initializer.js";

let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
const initialize=createInitializer();
initialize.addCustomFunctionHandlebars();
jQuery.validator.addMethod("phone", function(phone_number, element) {
    phone_number = phone_number.replace(/\s+/g, "");
    return this.optional(element) || phone_number.length > 9 && 
    phone_number.match(/010-\d{4}-\d{4}$/);
}, "핸드폰 번호 형식으로 써주세요");

jQuery.validator.addMethod("resident", function(resident_number, element) {
    resident_number = resident_number.replace(/\s+/g, "");
    return this.optional(element) || resident_number.length > 13 && 
    resident_number.match(/^\d{6}-\d{7}$/);
}, "주민등록번호 형식으로 써주세요");





function init() {
	
	registEvent();
	navigate();
}
/*
이벤트등록
*/
function registEvent() {
	/*
	$(window).on('load', function(e) {
		alert('load  event:' + e);
	});
	*/
	$(window).on('hashchange', function(e) {
		//alert('hashchange event:' + e);
		hash = window.location.hash
		path = hash.substring(1);
		navigate();
	});
	
	$(document).on('click', function(e) {
		//if ($(e.target).attr('data-navigate')) {
			//alert('click event --> hash변경:' + $(e.target).attr('data-navigate'));
			// 해쉬 변경
			//window.location.hash = e.target.getAttribute('data-navigate');
		//}
		if (e.target.getAttribute('data-navigate') == '/user_write_action' || e.target.getAttribute('data-navigate') == '/user_login_action') {
		
			if (window.location.hash.substring(1) == e.target.getAttribute('data-navigate')) {
				// 현재 hash 값과 button data-navigate 속성값이 같은 경우(hashchange 이벤트 발생 안함)
				 navigate();
			} else {
				// 현재 hash 값과 button data-navigate 속성값이 다른 경우(hashchange 이벤트 발생)
				window.location.hash = e.target.getAttribute('data-navigate');
			}
			
		} else {
			if(e.target.getAttribute('data-navigate')!=null){
				window.location.hash = e.target.getAttribute('data-navigate');
			}
		}
		
	});
}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	if (path == '/user_write_form') {
		html = user_write_form();
		$('#content').html(html);
		initialize.validatorUserWriteFormSetDefault();
		let validator = $('#user_write_form').validate();
		initialize.setValidator(validator);
	}
	if (path == '/user_write_action') {
		/**************** /user_write_action******************/
		if (initialize.getValidator().form()) {
			let sendJsonObject = {
					userId: document.f.userId.value,
					userPassword: document.f.password.value,
					userName: document.f.name.value,
					userGender: document.f.gender.value,
					userPhoneNumber: document.f.phone.value,
					userAddress: document.f.address.value,
					userResidentNumber : document.f.residentNumber.value
			}
			const responseJsonObject = ajaxRequest('POST','user',sendJsonObject);
			
			ajaxRequest('POST','user/login',sendJsonObject);
			
			window.location.href = 'index';
		}
	}
	if (path == '/login') {
		let sendJsonObject = {
				userId: document.f.loginUserId.value,
				userPassword: document.f.loginPassword.value,
		}
		const responseJsonObject = ajaxRequest('POST','user/login',sendJsonObject);
		html = user_login_form(responseJsonObject);
		$('#content').html(html);
	}
}



init();

