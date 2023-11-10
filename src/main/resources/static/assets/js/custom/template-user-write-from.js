
export function user_write_form(responseJsonObject = {}) {
	let htmlTemplate =
	`<!--header area start-->
    
    <!--offcanvas menu area start-->
    
    <!--header area end-->

    
    <!-- customer login start -->
    <th:block layout:fragment="content">
    <div id="content">
    <div class="customer_login">
        <div class="container">
            <div class="row">
               <!--login area start-->
               
                <!--login area start-->

                <!--register area start-->
                <div class="col-lg-6 col-md-6" style="margin-left: 300px;">
                    <div class="account_form register" style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
                        <h2 th:text="Register">회원가입</h2>
                        <form name="f" id="user_write_form" action="#" method="post" >
                            
                            <p>   
                                <label>아이디(이메일 형식으로 작성하세요) <span>*</span></label>
                                <input type="text" name="userId" id="userId" value="{{userId}}">
                                <span id="userIdError" style="color:red;"></span>
                             </p>
                
                             <p>
                                <label>비밀번호 <span>*</span></label>
                                <input type="password" name="password" id="password" value="{{userPassword}}">
                                <span id="passwordError" style="color:red;"></span>
                            </p>
                            <p>
                                <label>비밀번호 확인 <span>*</span></label>
                                <input type="password" name="confirmPassword" id="confirmPassword" value="{{userPassword}}">
                                <span id="confirmPasswordError" style="color:red;"></span>
                            </p>
                            <p>   
                                <label>이름  <span>*</span></label>
                                <input type="text" name="name" id="name" value="{{userName}}">
                                <span id="nameError" style="color:red;"></span>
                             </p>
                			
                			<p>   
                                <label>주민등록번호(ex:######-#######) <span>*</span></label>
                                <input type="text" name="residentNumber" id="residentNumber" value="{{userResidentNumber}}">
                                <span id="residentNumberError" style="color:red;"></span>
                            </p>
                			
                             <p>
                                <label>성별  <span>*</span></label>
                                <select id="gender" name="gender">
                                    <option value="">성별 선택</option>
                                    <option value="남">남</option>
                                    <option value="여">여</option>
                                </select>
                                <span id="genderError" style="color:red;"></span>
                             </p>
                
                             <p>   
                                <label>핸드폰번호(ex:010-####-####)  <span>*</span></label>
                                <input type="text" name="phone" id="phone" value="{{userPhoneNumber}}">
                                <span id="phoneError" style="color:red;"></span>
                             </p>

                             <p>   
                                <label>주소  <span>*</span></label>
                                <input type="text" name="address" id="address" value="{{userAddress}}">
                                
                                <span id="addressError" style="color:red;"></span>
                            </p>
                			
                            <div class="login_submit">
                                <button type="button" data-navigate="/user_write_action">확인</button>
                            </div>
						</form>
                        </div>
                    
                    </div>    
            
             
                 <!--login area start-->
            </div>
        </div>   
            </div> 
    </div>
    </th:block>
    <!-- customer login end -->

    <!--footer area start-->
    
    <!--footer area end-->`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
