
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
                     <form name="f">
                     <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                     <div class="form-floating">
                        <label>Id</label>
                        <input type="email" class="form-control" id="loginUserId"
                           placeholder="name@example.com">
                     </div>
                     <div class="form-floating">
                        <label>Password</label>
                        <input type="password" class="form-control" id="loginPassword"
                           placeholder="Password">
                     </div>

                     <div class="form-check text-start my-3">
                        <input class="form-check-input" type="checkbox" value="remember-me"
                           id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                           Remember me
                        </label>
                     </div>
                     <button class="btn btn-success w-100 py-1" type="button" data-navigate="#/login" >Sign in</button>
                     <!--<button type="button" data-navigate="#/login">Sign in</button>-->
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
      </div>
   </th:block>`;
	
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
