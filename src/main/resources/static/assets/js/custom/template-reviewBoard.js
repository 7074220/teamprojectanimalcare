
export function reviewBoard(responseJsonObject = {}) {
	let htmlTemplate =
		`<div class="reviews_wrapper">
        {{#each this}}
        <h2>{{boardDate}}</h2>
        <div class="reviews_comment_box">
            <div class="comment_thmb">
                <p><strong>{{userNo}}</strong></p>

            </div>
            <div class="comment_text">
                <div class="reviews_meta">
                   <div class="star_rating">
															<ul>
																<li>
																	<a href="#">
																		<img src={{starNumber boardStar 1}} alt="Filled Star">
																	</a>
																</li>
																<li>
																	<a href="#">
																		<img src={{starNumber boardStar 2}} alt="Filled Star">
																	</a>
																</li>
																<li>
																	<a href="#">
																		<img src={{starNumber boardStar 3}} alt="Filled Star">
																	</a>
																</li>
																<li>
																	<a href="#">
																		<img src={{starNumber boardStar 4}} alt="Filled Star">
																	</a>
																</li>
																<li>
																	<a href="#">
																		<img src={{starNumber boardStar 5}} alt="Filled Star">
																	</a>
																</li>
															</ul>

														</div>
               
                    <h2>
                        <p>{{boardTitle}}</p>
                    </h2>
                    <p>{{boardContent}}</p>
                </div>
            </div>
        </div>
        {{/each}}
    </div>
</div>`;

	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate(responseJsonObject);
	return resultTemplate;
}
