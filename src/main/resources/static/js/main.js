var categoryApi = Vue.resource('/api/categories');

Vue.component('category-row', {
	props:['category'],
	template: '<div>{{ category.name }}</div>'
});

Vue.component('categories-list', {
	props: ['categories'],
	template:
		'<div>' + 
			'<category-row v-for="category in categories" :key="category.id" :category="category" />' +
		'</div>',
	created: function(){
		categoryApi.get().then(result => 
			result.json().then(data => 
				data.forEach(category => this.categories.push(category))
			)
		)	
	}
});

var app = new Vue({
  el: '#app',
  template: '<categories-list :categories="categories" />',
  data: {
    categories: []
  }
});