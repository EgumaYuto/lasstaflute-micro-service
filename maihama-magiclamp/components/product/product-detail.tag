<product-detail>

  <h1>{productDetail.productName}</h1>
  <p>{productDetail.categoryName}</p>
  <p>¥{window.helper.formatMoneyComma(productDetail.regularPrice)}</p>

  <script>
    var obs = window.observable || {};
    var sa = window.superagent || {};
    var self = this;

    this.productDetail = {};

    obs.on(RC.EVENT.route.product.detail, function(product) {
      sa
        .get(RC.API.product.detail + (product || 1))
        .end(function(error, response) {
          if (response.ok) {
            obs.trigger(RC.EVENT.route.product.detailLoaded, JSON.parse(response.text));
          }
        });
    });

    obs.on(RC.EVENT.route.product.detailLoaded, function(data) {
      self.productDetail = data;
      self.update();
    });
  </script>
</product-detail>
