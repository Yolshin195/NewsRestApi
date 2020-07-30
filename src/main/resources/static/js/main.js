var newsApi = Vue.resource('news{/id}')

function getIndex(rows, row) {
  for (let i = 0; i < rows.length; i++) {
    if (rows[i].id === row.id) {
      return i;
    }
  }

  return -1;
}

Vue.component('news-form', {
  props: ['news', 'newsAttr'],
  data: function() {
    return {
      id: "",
      title: "",
      shortDescription: "",
      description: ""
    }
  },
  watch: {
    newsAttr: function(newsVal, oldVal) {
      this.id = newsVal.id;
      this.title = newsVal.title;
      this.shortDescription = newsVal.shortDescription;
      this.description  = newsVal.description;
    }
  },
  template: `
    <div>
      <input type="text" placeholder="Enter title ..." v-model="title"/>
      <input type="text" placeholder="Enter short ..." v-model="shortDescription"/>
      <input type="text" placeholder="Enter description ..." v-model="description"/>
      <input type="button" value="Vave" @click="save"/>
    </div>
  `,
  methods:{
    save: function() {
      var news = {
        title: this.title,
        shortDescription: this.shortDescription,
        description: this.description
      }

      if (this.id) {
        news.id = this.id;

        newsApi.update({}, news)
        .then(res => res.json())
        .then(row => {
          var index = getIndex(this.news, row); 
          this.news.splice(index, 1, row);
        })
        .then(() => {
          this.id = "";
          this.title = "";
          this.shortDescription = "";
          this.description = "";
        })
      } else {
        newsApi.save({}, news)
        .then(res => res.json())
        .then(row => this.news.push(row))
        .then(() => {
          this.title = "";
          this.shortDescription = "";
          this.description = "";
        })
      }
    }
  }
})

Vue.component('news-row', {
  props: ["news", "row", "editNews"],
  template: `
    <li>
      <i>({{row.title}})</i>
      {{row.shortDescription}}
      <span>
        <input type="button" value="Edit" @click="edit"/>
        <input type="button" value="Delete" @click="del"/>
      </span>
    </li>`,
  methods: {
    edit: function() {
      console.log("edit");
      this.editNews(this.row);
    },
    del: function() {
      newsApi.remove({id: this.row.id})
      .then(res => {
        if (res.ok) {
          this.news.splice(this.news.indexOf(this.row), 1);
        }
      })
    }
  } 
})

Vue.component('news-list', {
  props: ["news"],
  data: function() {
    return {
      newsAttr: null 
    }
  },
  template: `
    <div>
      <news-form :news="news" :newsAttr="newsAttr"/>
      <ul>
        <news-row v-for="row in news" :news="news" :row="row"
          :editNews="editNews" />
      </ul>
    </div>`,
  methods: {
    editNews: function(row) {
      this.newsAttr = row; 
    }
  },
  created: function() {
    newsApi.get()
    .then(res => res.json())
    .then(rows => rows.forEach(row => this.news.push(row)))
  }
})

var app = new Vue({
  el: '#app',
  template: '<news-list :news="news"/>',
  data: {
    news: [] 
  }
})
