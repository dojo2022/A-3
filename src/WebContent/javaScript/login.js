/**
 *
 */
document.addEventListener('DOMContentLoaded',function(event) {
						const targetElement = document.getElementById('inputUserPw');
						const triggerElement = document.getElementById('inputCheckbox');
						triggerElement.addEventListener('change', function(event) {
							if (this.checked) {
								targetElement.setAttribute('type', 'text');
							} else {
								targetElement.setAttribute('type', 'password');
							}
						}, false);
					}, false);