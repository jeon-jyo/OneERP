<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <logistics-table />
      </div>
    </div>
  </div>
</template>

<script>
import LogisticsTable from "./components/Logisics.vue";

export default {
  name: "ltables",
  components: {
    LogisticsTable,
  },
};
</script>
