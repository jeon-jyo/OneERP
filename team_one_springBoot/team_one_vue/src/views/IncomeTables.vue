<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <income-table />
      </div>
    </div>
  </div>
</template>

<script>
import IncomeTable from "./components/Income.vue";

export default {
  name: "itable",
  components: {
    IncomeTable,
  },
};
</script>
