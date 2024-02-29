<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <sales-table />
      </div>
    </div>
  </div>
</template>

<script>
import SalesTable from "./components/Sales.vue";

export default {
  name: "stables",
  components: {
    SalesTable,
  },
};
</script>
