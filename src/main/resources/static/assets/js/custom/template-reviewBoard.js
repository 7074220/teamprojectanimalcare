
export function reviewBoard(responseJsonObject = {}) {
	let htmlTemplate =
		`<div class="reviews_wrapper">
        {{#each reviewList}}
        <h2>{{review.boardDate}}</h2>
        <div class="reviews_comment_box">
            <div class="comment_thmb">
                <p><strong>{{review.userinfo.userName}}</strong></p>

            </div>
            <div class="comment_text">
                <div class="reviews_meta">
                    <div class="star_rating">
                        <ul>
                            {{#if (lte starNumber review.boardStar)}}
                    <img src="assets/img/icon/star-icon2.png" alt="Filled Star">
                {{else}}
                    <img src="assets/img/icon/star-icon.png" alt="Empty Star">
                {{/if}}
                        </ul>
                    </div>
               
                    <h2>
                        <p>{{review.boardTitle}}</p>
                    </h2>
                    <p>{{review.boardContent}}</p>
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
