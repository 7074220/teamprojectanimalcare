
export function user_finduserinfo_form(responseJsonObject = {}) {
	let htmlTemplate =
	`<th:block layout:fragment="content">
	<div id="content">
    <div class="customer_login">
        <div class="container">
            <div class="row">
               <!--login area start-->
                <div class="col-lg-6 col-md-6">
                 <div class="account_form register">
                        <h2>아이디 찾기</h2>
                        <form name="f" id="userFindIdForm" action="#">
                            <p>   
                                <label>이름 <span>*</span></label>
                                <input type="text" id="findName">
                             </p>
                             <p>   
                                <label>전화번호 <span>*</span></label>
                                <input type="text" id="findPhoneNumber">
                             </p>
                             <label id="findIdText" style="color: green"></label>
                            <div class="login_submit">
                                <button type="button" data-navigate="/findUserId">확인</button>
                            </div>
                        </form>
                    </div>  
                </div>
                <!--login area start-->

                <!--register area start-->
                <div class="col-lg-6 col-md-6">
					          <div class="account_form">
                        <h2>비밀번호 찾기</h2>
                        <form name="f2" id="userFindPasswordForm" action="#">
                            <p>   
                                <label>아이디<span>*</span></label>
                                <input type="text" id="findUserId">
                             </p>
                             <p>   
                                <label>전화번호<span>*</span></label>
                                <input type="text" id="findPhoneNumber2">
                             </p>   
                            <div class="login_submit">
                                <button type="button" onclick="findPassword()">확인</button>
                            </div>

                        </form>
                     </div>  
                 
                </div>
                <!--register area end-->
            </div>
        </div>    
    </div>
    </div>`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
