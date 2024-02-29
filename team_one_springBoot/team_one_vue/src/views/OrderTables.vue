<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <temp-table2 />
      </div>
    </div>
  </div>
</template>

<script>
import TempTable2 from "./components/OrderList2.vue";

export default {
  name: "tables2",
  components: {
    TempTable2,
  },
};
</script>
