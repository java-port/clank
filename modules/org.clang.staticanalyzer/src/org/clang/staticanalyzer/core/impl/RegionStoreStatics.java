/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type RegionStoreStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.RegionStoreStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL12isUnionFieldPKN5clang4ento11FieldRegionE;_ZL13isRecordEmptyPKN5clang10RecordDeclE;_ZL17getUnderlyingTypePKN5clang4ento9SubRegionE;_ZL22getExistingLazyBindingRN5clang4ento11SValBuilderERKN12_GLOBAL__N_117RegionBindingsRefEPKNS0_9SubRegionEb;_ZL22isCompatibleWithFieldsN12_GLOBAL__N_110BindingKeyERKN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE;_ZL23getSymbolicOffsetFieldsN12_GLOBAL__N_110BindingKeyERN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE;_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionES3_b;_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionEb; -static-type=RegionStoreStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class RegionStoreStatics {

//<editor-fold defaultstate="collapsed" desc="isUnionField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 749,
 FQN="isUnionField", NM="_ZL12isUnionFieldPKN5clang4ento11FieldRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL12isUnionFieldPKN5clang4ento11FieldRegionE")
//</editor-fold>
public static /*inline*/ boolean isUnionField(/*const*/ FieldRegion /*P*/ FR) {
  return FR.getDecl().getParent$Const().isUnion();
}

//<editor-fold defaultstate="collapsed" desc="getSymbolicOffsetFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 755,
 FQN="getSymbolicOffsetFields", NM="_ZL23getSymbolicOffsetFieldsN12_GLOBAL__N_110BindingKeyERN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL23getSymbolicOffsetFieldsN12_GLOBAL__N_110BindingKeyERN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE")
//</editor-fold>
public static void getSymbolicOffsetFields(BindingKey K, final SmallVector</*const*/ FieldDecl /*P*/ > /*&*/ Fields) {
  assert (K.hasSymbolicOffset()) : "Not implemented for concrete offset keys";
  
  /*const*/ MemRegion /*P*/ Base = K.getConcreteOffsetRegion();
  /*const*/ MemRegion /*P*/ R = K.getRegion();
  while (R != Base) {
    {
      /*const*/ FieldRegion /*P*/ FR = dyn_cast_FieldRegion(R);
      if ((FR != null)) {
        if (!isUnionField(FR)) {
          Fields.push_back(FR.getDecl());
        }
      }
    }
    
    R = cast_SubRegion(R).getSuperRegion();
  }
}

//<editor-fold defaultstate="collapsed" desc="isCompatibleWithFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 770,
 FQN="isCompatibleWithFields", NM="_ZL22isCompatibleWithFieldsN12_GLOBAL__N_110BindingKeyERKN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL22isCompatibleWithFieldsN12_GLOBAL__N_110BindingKeyERKN4llvm11SmallVectorIPKN5clang9FieldDeclELj8EEE")
//</editor-fold>
public static boolean isCompatibleWithFields(BindingKey K, final /*const*/SmallVector</*const*/ FieldDecl /*P*/ > /*&*/ Fields) {
  assert (K.hasSymbolicOffset()) : "Not implemented for concrete offset keys";
  if (Fields.empty()) {
    return true;
  }
  
  SmallVector</*const*/ FieldDecl /*P*/ > FieldsInBindingKey/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(8, (/*const*/ FieldDecl /*P*/ )null);
  getSymbolicOffsetFields(new BindingKey(K), FieldsInBindingKey);
  
  int Delta = FieldsInBindingKey.size() - Fields.size();
  if (Delta >= 0) {
    return std.equal(FieldsInBindingKey.begin().$add(Delta), 
        FieldsInBindingKey.end(), 
        Fields.begin$Const());
  } else {
    return std.equal(FieldsInBindingKey.begin(), FieldsInBindingKey.end(), 
        Fields.begin$Const().$sub(Delta));
  }
}


/// Collects all bindings in \p Cluster that may refer to bindings within
/// \p Top.
///
/// Each binding is a pair whose \c first is the key (a BindingKey) and whose
/// \c second is the value (an SVal).
///
/// The \p IncludeAllDefaultBindings parameter specifies whether to include
/// default bindings that may extend beyond \p Top itself, e.g. if \p Top is
/// an aggregate within a larger aggregate with a default binding.
//<editor-fold defaultstate="collapsed" desc="collectSubRegionBindings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 798,
 FQN="collectSubRegionBindings", NM="_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionES3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionES3_b")
//</editor-fold>
public static void collectSubRegionBindings(final SmallVectorImpl<std.pairTypeType<BindingKey, SVal> > /*&*/ Bindings, 
                        final SValBuilder /*&*/ SVB, final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster, 
                        /*const*/ SubRegion /*P*/ Top, BindingKey TopKey, 
                        boolean IncludeAllDefaultBindings) {
  SmallVector</*const*/ FieldDecl /*P*/ > FieldsInSymbolicSubregions/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(8, (/*const*/ FieldDecl /*P*/ )null);
  if (TopKey.hasSymbolicOffset()) {
    getSymbolicOffsetFields(new BindingKey(TopKey), FieldsInSymbolicSubregions);
    Top = cast_SubRegion(TopKey.getConcreteOffsetRegion());
    TopKey.$assignMove(BindingKey.Make(Top, BindingKey.Kind.Default));
  }
  
  // Find the length (in bits) of the region being invalidated.
  long/*uint64_t*/ Length = UINT64_MAX;
  SVal Extent = new SVal(JD$Move.INSTANCE, Top.getExtent(SVB));
  {
    Optional<NsNonloc.ConcreteInt> ExtentCI = Extent.getAs(NsNonloc.ConcreteInt.class);
    if (ExtentCI.$bool()) {
      final /*const*/ APSInt /*&*/ ExtentInt = ExtentCI.$arrow().getValue();
      assert (ExtentInt.isNonNegative() || ExtentInt.isUnsigned());
      // Extents are in bytes but region offsets are in bits. Be careful!
      Length = ExtentInt.getLimitedValue() * SVB.getContext().getCharWidth();
    } else {
      /*const*/ FieldRegion /*P*/ FR = dyn_cast_FieldRegion(Top);
      if ((FR != null)) {
        if (FR.getDecl().isBitField()) {
          Length = $uint2ulong(FR.getDecl().getBitWidthValue(SVB.getContext()));
        }
      }
    }
  }
  ImmutableMap.iterator<BindingKey, SVal> I = null;
  ImmutableMap.iterator<BindingKey, SVal> E = null;
  try {
    
    for (I = Cluster.begin(), E = Cluster.end();
         I.$noteq(E); I.$preInc()) {
      BindingKey NextKey = new BindingKey(I.getKey());
      if (NextKey.getRegion() == TopKey.getRegion()) {
        // FIXME: This doesn't catch the case where we're really invalidating a
        // region with a symbolic offset. Example:
        //      R: points[i].y
        //   Next: points[0].x
        if ($greater_ulong(NextKey.getOffset(), TopKey.getOffset())
           && $less_ullong_ulong(NextKey.getOffset() - TopKey.getOffset(), Length)) {
          // Case 1: The next binding is inside the region we're invalidating.
          // Include it.
          Bindings.push_back((std.pairTypeType<BindingKey, SVal>)I.$star());
        } else if (NextKey.getOffset() == TopKey.getOffset()) {
          // Case 2: The next binding is at the same offset as the region we're
          // invalidating. In this case, we need to leave default bindings alone,
          // since they may be providing a default value for a regions beyond what
          // we're invalidating.
          // FIXME: This is probably incorrect; consider invalidating an outer
          // struct whose first field is bound to a LazyCompoundVal.
          if (IncludeAllDefaultBindings || NextKey.isDirect()) {
            Bindings.push_back((std.pairTypeType<BindingKey, SVal>)I.$star());
          }
        }
      } else if (NextKey.hasSymbolicOffset()) {
        /*const*/ MemRegion /*P*/ Base = NextKey.getConcreteOffsetRegion();
        if (Top.isSubRegionOf(Base)) {
          // Case 3: The next key is symbolic and we just changed something within
          // its concrete region. We don't know if the binding is still valid, so
          // we'll be conservative and include it.
          if (IncludeAllDefaultBindings || NextKey.isDirect()) {
            if (isCompatibleWithFields(new BindingKey(NextKey), FieldsInSymbolicSubregions)) {
              Bindings.push_back((std.pairTypeType<BindingKey, SVal>)I.$star());
            }
          }
        } else {
          /*const*/ SubRegion /*P*/ BaseSR = dyn_cast_SubRegion(Base);
          if ((BaseSR != null)) {
            // Case 4: The next key is symbolic, but we changed a known
            // super-region. In this case the binding is certainly included.
            if (Top == Base || BaseSR.isSubRegionOf(Top)) {
              if (isCompatibleWithFields(new BindingKey(NextKey), FieldsInSymbolicSubregions)) {
                Bindings.push_back((std.pairTypeType<BindingKey, SVal>)I.$star());
              }
            }
          }
        }
      }
    }
  } finally {
    if (E != null) { E.$destroy(); }
    if (I != null) { I.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="collectSubRegionBindings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 870,
 FQN="collectSubRegionBindings", NM="_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL24collectSubRegionBindingsRN4llvm15SmallVectorImplISt4pairIN12_GLOBAL__N_110BindingKeyEN5clang4ento4SValEEEERNS5_11SValBuilderERKNS_12ImmutableMapIS3_S6_NS_16ImutKeyValueInfoIS3_S6_EEEEPKNS5_9SubRegionEb")
//</editor-fold>
public static void collectSubRegionBindings(final SmallVectorImpl<std.pairTypeType<BindingKey, SVal> > /*&*/ Bindings, 
                        final SValBuilder /*&*/ SVB, final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster, 
                        /*const*/ SubRegion /*P*/ Top, boolean IncludeAllDefaultBindings) {
  collectSubRegionBindings(Bindings, SVB, Cluster, Top, 
      BindingKey.Make(Top, BindingKey.Kind.Default), 
      IncludeAllDefaultBindings);
}

//<editor-fold defaultstate="collapsed" desc="getUnderlyingType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1475,
 FQN="getUnderlyingType", NM="_ZL17getUnderlyingTypePKN5clang4ento9SubRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL17getUnderlyingTypePKN5clang4ento9SubRegionE")
//</editor-fold>
public static QualType getUnderlyingType(/*const*/ SubRegion /*P*/ R) {
  QualType RegionTy/*J*/= new QualType();
  {
    /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_TypedValueRegion(R);
    if ((TVR != null)) {
      RegionTy.$assignMove(TVR.getValueType());
    }
  }
  {
    
    /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
    if ((SR != null)) {
      RegionTy.$assignMove(SR.getSymbol().getType());
    }
  }
  
  return RegionTy;
}


/// Checks to see if store \p B has a lazy binding for region \p R.
///
/// If \p AllowSubregionBindings is \c false, a lazy binding will be rejected
/// if there are additional bindings within \p R.
///
/// Note that unlike RegionStoreManager::findLazyBinding, this will not search
/// for lazy bindings for super-regions of \p R.
//<editor-fold defaultstate="collapsed" desc="getExistingLazyBinding">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1493,
 FQN="getExistingLazyBinding", NM="_ZL22getExistingLazyBindingRN5clang4ento11SValBuilderERKN12_GLOBAL__N_117RegionBindingsRefEPKNS0_9SubRegionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL22getExistingLazyBindingRN5clang4ento11SValBuilderERKN12_GLOBAL__N_117RegionBindingsRefEPKNS0_9SubRegionEb")
//</editor-fold>
public static Optional<NsNonloc.LazyCompoundVal> getExistingLazyBinding(final SValBuilder /*&*/ SVB, final /*const*/ RegionBindingsRef /*&*/ B, 
                      /*const*/ SubRegion /*P*/ R, boolean AllowSubregionBindings) {
  Optional<SVal> V = B.getDefaultBinding(R);
  if (!V.$bool()) {
    return new Optional<NsNonloc.LazyCompoundVal>(None);
  }
  
  Optional<NsNonloc.LazyCompoundVal> LCV = V.$arrow().getAs(NsNonloc.LazyCompoundVal.class);
  if (!LCV.$bool()) {
    return new Optional<NsNonloc.LazyCompoundVal>(None);
  }
  
  // If the LCV is for a subregion, the types might not match, and we shouldn't
  // reuse the binding.
  QualType RegionTy = getUnderlyingType(R);
  if (!RegionTy.isNull()
     && !RegionTy.$arrow().isVoidPointerType()) {
    QualType SourceRegionTy = LCV.$arrow().getRegion().getValueType();
    if (!SVB.getContext().hasSameUnqualifiedType(new QualType(RegionTy), new QualType(SourceRegionTy))) {
      return new Optional<NsNonloc.LazyCompoundVal>(None);
    }
  }
  if (!AllowSubregionBindings) {
    // If there are any other bindings within this region, we shouldn't reuse
    // the top-level binding.
    SmallVector<std.pairTypeType<BindingKey, SVal>> Bindings/*J*/= new SmallVector<std.pairTypeType<BindingKey, SVal>>(16, new std.pairTypeType<BindingKey, SVal>(new BindingKey(), new SVal()));
    collectSubRegionBindings(Bindings, SVB, $Deref(B.lookup(R.getBaseRegion()).$star()), R, 
        /*IncludeAllDefaultBindings=*/ true);
    if ($greater_uint(Bindings.size(), 1)) {
      return new Optional<NsNonloc.LazyCompoundVal>(None);
    }
  }
  
  return new Optional<NsNonloc.LazyCompoundVal>(JD$T$C$R.INSTANCE, LCV.$star());
}

//<editor-fold defaultstate="collapsed" desc="isRecordEmpty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 1922,
 FQN="isRecordEmpty", NM="_ZL13isRecordEmptyPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZL13isRecordEmptyPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean isRecordEmpty(/*const*/ RecordDecl /*P*/ RD) {
  if (!RD.field_empty()) {
    return false;
  }
  {
    /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(RD);
    if ((CRD != null)) {
      return CRD.getNumBases() == 0;
    }
  }
  return true;
}

} // END OF class RegionStoreStatics
