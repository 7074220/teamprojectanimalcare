
export function user_write_form(responseJsonObject = {}) {
	let htmlTemplate =
	`<!--header area start-->
    
    <!--offcanvas menu area start-->
    
    <!--header area end-->

    <!--breadcrumbs area start-->
    <th:block layout:fragment="content">
    <div class="breadcrumbs_area">
        <div class="container">   
            <div class="row">
                <div class="col-12">
                    <div class="breadcrumb_content">
                       <h3>Login</h3>
                        <ul>
                            <li><a href="index.html">home</a></li>
                            <li>Login</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>         
    </div>
    <!--breadcrumbs area end-->
    
    <!-- customer login start -->
    
    <div class="customer_login">
        <div class="container">
            <div class="row">
               <!--login area start-->
               
                <!--login area start-->

                <!--register area start-->
                <div class="col-lg-6 col-md-6">
                    <div class="account_form register">
                        <h2 th:text="Register">회원가입</h2>
                        <form name="f" action="my-account.html" method="post" >
                            
                            <p>   
                                <label>아이디 <span>*</span></label>
                                <input type="text" id="userId" value="{{userId}}">
                                <span id="userIdError" style="color:red;"></span>
                             </p>
                
                             <p>
                                <label>비밀번호 <span>*</span></label>
                                <input type="password" id="password" value="{{userPassword}}">
                                <span id="passwordError" style="color:red;"></span>
                            </p>
                            <p>
                                <label>비밀번호 확인 <span>*</span></label>
                                <input type="password" id="confirmPassword" value="{{userPassword}}">
                                <span id="confirmPasswordError" style="color:red;"></span>
                            </p>
                            <p>   
                                <label>이름  <span>*</span></label>
                                <input type="text" id="name" value="{{userName}}">
                                <span id="nameError" style="color:red;"></span>
                             </p>
                
                             <p>
                                <label>성별  <span>*</span></label>
                                <select id="gender">
                                    <option value="">성별 선택</option>
                                    <option value="남">남</option>
                                    <option value="여">여</option>
                                </select>
                                <span id="genderError" style="color:red;"></span>
                             </p>
                
                             <p>   
                                <label>핸드폰번호  <span>*</span></label>
                                <input type="text" id="phone" value="{{userPhoneNumber}}">
                                <span id="phoneError" style="color:red;"></span>
                             </p>

                             <p>   
                                <label>주소  <span>*</span></label>
                                <input type="text" id="address" value="{{userAddress}}">
                                
                                <span id="addressError" style="color:red;"></span>
                            </p>
                
                            <div class="login_submit">
                                <button type="button" data-navigate="/user_write_action">확인</button>
                            </div>
						</form>
                        </div>
                    
                    </div>    
            
             
                 <!--login area start-->

                <!--register area start-->
                <div class="col-lg-6 col-md-6">
                    <div class="account_form register">
                        <h2 th:text="MyPet">MyPet</h2>
                        <form action="#">
                            <p>   
                                <label th:text="이름">이름  <span>*</span></label>
                                <input type="text">
                             </p>
                             <p>   
                                <label th:text="생일">생일 <span>*</span></label>
                                <input type="text">
                             </p>
                              <p>
                                <label>종류  <span>*</span></label>
                                <select id="kind">
                                    <option value="">종류 선택</option>
                                    <option value="남" th:text="강아지" th:value="강아지">남</option>
                                    <option value="여" th:text="고양이" th:value="고양이">여</option>
                                </select>
                                <span id="kindError" style="color:red;"></span>
                             </p>
                
                            <!--<div class="login_submit">
                                <button type="submit" th:text="등록">Register</button>
                            </div>-->
                        </form>
                    </div>    
                </div>
                <!--register area end-->
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
