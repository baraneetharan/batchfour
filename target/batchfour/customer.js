var app = new (function () {
    // alert("app called");
  this.create = function () {
    // document.getElementById("name").value
      var customername=document.getElementById("customername").value;
    // console.log("create called " + customername);
    var newCustomer={"customername":document.getElementById("customername").value};
    console.log(newCustomer);
    
    // Call Ajax
    $.ajax({
        type: "POST",
        url: "http://localhost:9090/customer",
        data: JSON.stringify(newCustomer),
        success: function(result) {
            alert('msg');
        },
        error: function(result) {
            alert('msg');
        }
    });
  };
  this.select = function () {
    console.log("select called");
  };
  this.update = function () {
    console.log("update called");
  };
  this.delete = function () {
    console.log("delete called");
  };
})();
