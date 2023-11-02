
export function user_login_form(responseJsonObject = {}) {
	let htmlTemplate =
	`<th:block layout:fragment="content">
	<div id="content">
    <!--breadcrumbs area end-->
    
    <!-- customer login start -->
    
    <div class="customer_login" id="content">
        <div class="container">
            <div class="row">
               <!--login area start-->
               <div class="col-lg-6 col-md-6">
                <div class="account_form">
                    <h2>로그인</h2>
                    <form name="f" action="my-account.html" onsubmit="return validateLoginForm()">
                        
                        <p>   
                            <label>아이디 <span>*</span></label>
                            <input type="text" id="loginUserId">
                         </p>
                         <p>   
                            <label>비밀번호 <span>*</span></label>
                            <input type="password" id="loginPassword">
                         </p>   
                        <div class="login_submit">
                           <a href="#"></a>
                            <label for="remember">
                                <input id="remember" type="checkbox">
                                Remember me
                            </label>
                            <button type="button" data-navigate="#/login" >로그인</button>
                        </div>
                    </form>
                 </div>    
            </div>
                <!--login area start-->

                <!--register area start-->
                
                <!--register area end-->
            </div>
        </div>    
    </div>
    </th:block>`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
