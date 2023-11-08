
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
                        <form name="userFindIdForm" id="userFindIdForm" action="#">
                            <p>   
                                <label>이름 <span>*</span></label>
                                <input type="text" id="name">
                                <span id="findNameError" style="color:red;"></span>
                             </p>
                             <p>   
                                <label>전화번호 <span>*</span></label>
                                <input type="text" id="phone">
                                <span id="findPhoneNumberError" style="color:red;"></span>
                             </p>
                             <label id="findIdText" style="color: green"></label>
                            <div class="login_submit">
                                <button type="button" data-navigate="/findUserId">확인</button>
                            </div>
                        </form>
                    </div>  
                </div>
                <!--login area start-->

                
            </div>
        </div>    
    </div>
    </div>`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
