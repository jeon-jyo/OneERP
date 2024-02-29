<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <finance-table />
      </div>
    </div>
  </div>
</template>

<script>
import FinanceTable from "./components/Finance.vue";

export default {
  name: "ftable",
  components: {
    FinanceTable,
  },
};
</script>
