/*
@FunctionalInterface
public interface MemRegion2MemRegion <T extends MemRegion> {
  T $call(MemRegion p);
}

private static final java.util.Map<Class<? extends MemRegion>, MemRegion2MemRegion> DynCastMemRegion = new java.util.HashMap<>(64);
static void mapMemRegionTypeClass(Class<? extends MemRegion> MemRegionClass, MemRegion2MemRegion dynCast) {
  DynCastMemRegion.put(MemRegionClass, dynCast);
}

static { mapMemRegionTypeClass(StaticGlobalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StaticGlobalSpaceRegion);}
static { mapMemRegionTypeClass(StackLocalsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackLocalsSpaceRegion);}
static { mapMemRegionTypeClass(DeclRegion.class, StaticanalyzerRTTI::dyn_cast_DeclRegion);}
static { mapMemRegionTypeClass(GlobalSystemSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalSystemSpaceRegion);}
static { mapMemRegionTypeClass(StackSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackSpaceRegion);}
static { mapMemRegionTypeClass(ElementRegion.class, StaticanalyzerRTTI::dyn_cast_ElementRegion);}
static { mapMemRegionTypeClass(CXXThisRegion.class, StaticanalyzerRTTI::dyn_cast_CXXThisRegion);}
static { mapMemRegionTypeClass(FunctionCodeRegion.class, StaticanalyzerRTTI::dyn_cast_FunctionCodeRegion);}
static { mapMemRegionTypeClass(GlobalImmutableSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalImmutableSpaceRegion);}
static { mapMemRegionTypeClass(CodeSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_CodeSpaceRegion);}
static { mapMemRegionTypeClass(UnknownSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_UnknownSpaceRegion);}
static { mapMemRegionTypeClass(CXXTempObjectRegion.class, StaticanalyzerRTTI::dyn_cast_CXXTempObjectRegion);}
static { mapMemRegionTypeClass(BlockCodeRegion.class, StaticanalyzerRTTI::dyn_cast_BlockCodeRegion);}
static { mapMemRegionTypeClass(HeapSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_HeapSpaceRegion);}
static { mapMemRegionTypeClass(NonStaticGlobalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_NonStaticGlobalSpaceRegion);}
static { mapMemRegionTypeClass(ObjCStringRegion.class, StaticanalyzerRTTI::dyn_cast_ObjCStringRegion);}
static { mapMemRegionTypeClass(MemSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_MemSpaceRegion);}
static { mapMemRegionTypeClass(AllocaRegion.class, StaticanalyzerRTTI::dyn_cast_AllocaRegion);}
static { mapMemRegionTypeClass(StringRegion.class, StaticanalyzerRTTI::dyn_cast_StringRegion);}
static { mapMemRegionTypeClass(SubRegion.class, StaticanalyzerRTTI::dyn_cast_SubRegion);}
static { mapMemRegionTypeClass(CXXBaseObjectRegion.class, StaticanalyzerRTTI::dyn_cast_CXXBaseObjectRegion);}
static { mapMemRegionTypeClass(TypedRegion.class, StaticanalyzerRTTI::dyn_cast_TypedRegion);}
static { mapMemRegionTypeClass(TypedValueRegion.class, StaticanalyzerRTTI::dyn_cast_TypedValueRegion);}
static { mapMemRegionTypeClass(StackArgumentsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_StackArgumentsSpaceRegion);}
static { mapMemRegionTypeClass(SymbolicRegion.class, StaticanalyzerRTTI::dyn_cast_SymbolicRegion);}
static { mapMemRegionTypeClass(GlobalInternalSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalInternalSpaceRegion);}
static { mapMemRegionTypeClass(BlockDataRegion.class, StaticanalyzerRTTI::dyn_cast_BlockDataRegion);}
static { mapMemRegionTypeClass(CompoundLiteralRegion.class, StaticanalyzerRTTI::dyn_cast_CompoundLiteralRegion);}
static { mapMemRegionTypeClass(ObjCIvarRegion.class, StaticanalyzerRTTI::dyn_cast_ObjCIvarRegion);}
static { mapMemRegionTypeClass(VarRegion.class, StaticanalyzerRTTI::dyn_cast_VarRegion);}
static { mapMemRegionTypeClass(FieldRegion.class, StaticanalyzerRTTI::dyn_cast_FieldRegion);}
static { mapMemRegionTypeClass(CodeTextRegion.class, StaticanalyzerRTTI::dyn_cast_CodeTextRegion);}
static { mapMemRegionTypeClass(GlobalsSpaceRegion.class, StaticanalyzerRTTI::dyn_cast_GlobalsSpaceRegion);}
*/