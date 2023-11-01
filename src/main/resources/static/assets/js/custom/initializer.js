function createInitializer() {
	let validator = {};
	
	const initializer = {
		
		setValidator: function(v) {
			console.log(v);
			validator = v;
		}
		,
		getValidator: function() {
			return validator;
		},
		
		addCustomFunctionHandlebars: function() {
			/*****Handlebars 함수등록 */
			Handlebars.registerHelper('substring', function(str, start, end) {
				return str.substring(start, end);
			});
			Handlebars.registerHelper('toUpper', function(str) {
				return str.toUpperCase();
			});
			Handlebars.registerHelper('ifCond', function(v1, operator, v2, options) {
				switch (operator) {
					case '==':
						return (v1 == v2) ? options.fn(this) : options.inverse(this);
					case '===':
						return (v1 === v2) ? options.fn(this) : options.inverse(this);
					case '!=':
						return (v1 != v2) ? options.fn(this) : options.inverse(this);
					case '!==':
						return (v1 !== v2) ? options.fn(this) : options.inverse(this);
					case '<':
						return (v1 < v2) ? options.fn(this) : options.inverse(this);
					case '<=':
						return (v1 <= v2) ? options.fn(this) : options.inverse(this);
					case '>':
						return (v1 > v2) ? options.fn(this) : options.inverse(this);
					case '>=':
						return (v1 >= v2) ? options.fn(this) : options.inverse(this);
					case '&&':
						return (v1 && v2) ? options.fn(this) : options.inverse(this);
					case '||':
						return (v1 || v2) ? options.fn(this) : options.inverse(this);
					default:
						return options.inverse(this);
				}
			});

		},
		getMessageScript: function() {
			$.getScript(`js/localization/messages_${navigator.language}.js`);
		},
		validatorSetDefault: function() {
			$.validator.setDefaults({});
		},
		validatorUserWriteFormSetDefault: function() {
			$.validator.setDefaults({
		rules: {
			userId: {
				required: true,
				minlength: 3,
				maxlength: 6,
				remote: {
					url: 'user/idcheck',
					type: 'GET',
					data: {
						userId: function() {
							return $('#userId').val();
						}
					}
				}
			},
			password: {
				required: true
			},
			confirmPassword: {
				required: true,
				equalTo: '#password'
			},
			name: {
				required: true
			},
			
		},
		messages: {
			userId: {
				required: '아이디를 입력하세요.',
				minlength: '아이디는 {0}글자 이상입니다.',
				maxlength: '아이디는 {0}글자 이하입니다.',
				remote: '{0}는 중복된 아이디입니다.'
			},
			password: {
				required: '패스워드를 입력하세요.'
			},
			confirmPassword: {
				required: '패스워드 확인을 입력하세요.',
				equalTo: '패스워드가 일치하지 않습니다.'
			},
			name: {
				required: '이름을 입력하세요.'
			},
		},
		errorClass: 'error',
		validClass: 'valid'
	});
		}
		

	}

	return initializer;
}
export { createInitializer };