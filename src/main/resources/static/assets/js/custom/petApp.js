import {petList} from './template-pet-list';
import {ajaxRequest} from './request.js';

//작성진행중
let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
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
		
	$(document).ready(function(){
    $('#short').change(function(){
        var selectedValue = $(this).val();  // 선택된 값을 가져옵니다.

        // 선택된 값을 기반으로 새로운 해시를 설정합니다.
        window.location.hash = 'pet/'+selectedValue;
        
    });
});
		
	});
}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	
	if (path.startsWith('/guest_write_form')) {
		/**************** /user_write_action******************/
		let sendJsonObject = {
			petType:$("#short").val(),
		}
		const responseJsonObject = ajaxRequest('GET','pet/'+'강아지',sendJsonObject);
		html = petList(responseJsonObject);
		$('#content').html(html);
	}
}



init();

