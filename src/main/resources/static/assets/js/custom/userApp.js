import {user_write_form} from './template-user-write-from.js';
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
    //phone_number = phone_number.replace(/\s+/g, "");
    return this.optional(element) || phone_number.length == 13 && 
    phone_number.match(/^\\d{3}-\\d{3,4}-\\d{4}$/);
}, "핸드폰 번호 형식으로 써주세요");

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
		alert('hashchange event:' + e);
		hash = window.location.hash
		path = hash.substring(1);
		navigate();
	});
	
	$(document).on('click', function(e) {
		if ($(e.target).attr('data-navigate')) {
			alert('click event --> hash변경:' + $(e.target).attr('data-navigate'));
			// 해쉬 변경
			window.location.hash = e.target.getAttribute('data-navigate');
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
					userAddress: document.f.address.value
			}
			const responseJsonObject = ajaxRequest('POST','user',sendJsonObject);
			
			if(responseJsonObject.msg!=null){
				window.location.href = 'login';
			}else {
				html = user_write_form(responseJsonObject);
				$('#content').html(html);
				initialize.validatorUserWriteFormSetDefault();
				let validator = $('#user_write_form').validate();
				initialize.setValidator(validator);
			}
		}
		
	}
}



init();

