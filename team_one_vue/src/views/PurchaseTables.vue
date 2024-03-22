<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <purchase-table />
      </div>
    </div>
  </div>
</template>

<script>
import PurchaseTable from "./components/Purchase.vue";

export default {
  name: "ptablses",
  components: {
    PurchaseTable,
  },
};
</script>
