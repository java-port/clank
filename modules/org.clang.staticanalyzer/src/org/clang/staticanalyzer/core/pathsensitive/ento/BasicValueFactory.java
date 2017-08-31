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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 62,
 FQN="clang::ento::BasicValueFactory", NM="_ZN5clang4ento17BasicValueFactoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactoryE")
//</editor-fold>
public class BasicValueFactory implements Destructors.ClassWithDestructor {
  /*typedef llvm::FoldingSet<llvm::FoldingSetNodeWrapper<llvm::APSInt> > APSIntSetTy*/
//  public final class APSIntSetTy extends FoldingSet<FoldingSetNodeWrapper<APSInt>>{ };
  
  private final ASTContext /*&*/ Ctx;
  private final BumpPtrAllocatorImpl /*&*/ BPAlloc;
  
  private FoldingSet<FoldingSetNodeWrapper<APSInt>> APSIntSet;
  private Object/*void P*/ PersistentSVals;
  private Object/*void P*/ PersistentSValPairs;
  
  private ImmutableListFactory<SVal> SValListFactory;
  private FoldingSet<CompoundValData> CompoundValDataSet;
  private FoldingSet<LazyCompoundValData> LazyCompoundValDataSet;
  
  // This is private because external clients should use the factory
  // method that takes a QualType.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 95,
   FQN="clang::ento::BasicValueFactory::getValue", NM="_ZN5clang4ento17BasicValueFactory8getValueEyjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory8getValueEyjb")
  //</editor-fold>
  private /*const*/ APSInt /*&*/ getValue(long/*uint64_t*/ X, /*uint*/int BitWidth, 
          boolean isUnsigned) {
    APSInt V/*J*/= new APSInt(BitWidth, isUnsigned);
    V.$assign(X);
    return getValue(V);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::BasicValueFactory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 82,
   FQN="clang::ento::BasicValueFactory::BasicValueFactory", NM="_ZN5clang4ento17BasicValueFactoryC1ERNS_10ASTContextERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactoryC1ERNS_10ASTContextERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public BasicValueFactory(final ASTContext /*&*/ ctx, final BumpPtrAllocatorImpl /*&*/ Alloc) {
    // : Ctx(ctx), BPAlloc(Alloc), APSIntSet(), PersistentSVals(null), PersistentSValPairs(null), SValListFactory(Alloc), CompoundValDataSet(), LazyCompoundValDataSet() 
    //START JInit
    this./*&*/Ctx=/*&*/ctx;
    this./*&*/BPAlloc=/*&*/Alloc;
    this.APSIntSet = new FoldingSet<FoldingSetNodeWrapper<APSInt>>(FoldingSetNodeWrapper.$Trait());
    this.PersistentSVals = null;
    this.PersistentSValPairs = null;
    this.SValListFactory = new ImmutableListFactory<SVal>(Alloc);
    this.CompoundValDataSet = new FoldingSet<CompoundValData>(CompoundValData.$Trait());
    this.LazyCompoundValDataSet = new FoldingSet<LazyCompoundValData>(LazyCompoundValData.$Trait());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::~BasicValueFactory">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 61,
   FQN="clang::ento::BasicValueFactory::~BasicValueFactory", NM="_ZN5clang4ento17BasicValueFactoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactoryD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Note that the dstor for the contents of APSIntSet will never be called,
    // so we iterate over the set and invoke the dstor for each APSInt.  This
    // frees an aux. memory allocated to represent very large constants.
    for (FoldingSetIterator<FoldingSetNodeWrapper<APSInt> > I = APSIntSet.begin(), E = APSIntSet.end(); I.$noteq(E); I.$preInc())  {
      I.$arrow().getValue().$destroy();
    }
    
    if ((FoldingSet<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >> /*P*/)PersistentSVals != null) { ((FoldingSet<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >> /*P*/)PersistentSVals).$destroy();};
    if ((FoldingSet<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >> /*P*/)PersistentSValPairs != null) { ((FoldingSet<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >> /*P*/)PersistentSValPairs).$destroy();};
    //START JDestroy
    LazyCompoundValDataSet.$destroy();
    CompoundValDataSet.$destroy();
    SValListFactory.$destroy();
    APSIntSet.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 88,
   FQN="clang::ento::BasicValueFactory::getContext", NM="_ZNK5clang4ento17BasicValueFactory10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZNK5clang4ento17BasicValueFactory10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() /*const*/ {
    return Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone for FoldingSetNodeWrapper*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 72,
   FQN="clang::ento::BasicValueFactory::getValue", NM="_ZN5clang4ento17BasicValueFactory8getValueERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory8getValueERKN4llvm6APSIntE")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getValue(final /*const*/ APSInt /*&*/ X) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    final type$ref<type$ptr<FoldingSetNodeWrapper<APSInt> /*P*/>/*void P*/ > InsertPos = create_type$ref();
    /*typedef llvm::FoldingSetNodeWrapper<llvm::APSInt> FoldNodeTy*/
//    final class FoldNodeTy extends FoldingSetNodeWrapper<APSInt>{ };
    
    X.Profile(ID);
    FoldingSetNodeWrapper<APSInt> /*P*/ P = APSIntSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(P != null)) {
      P = (FoldingSetNodeWrapper<APSInt> /*P*/ )BPAlloc.<FoldingSetNodeWrapper>Allocate$T(FoldingSetNodeWrapper.class);
      /*NEW_EXPR [System]*/P = /*new (P)*/ $new_uint_voidPtr(P, (type$ptr<?> New$Mem)->{
          return new FoldingSetNodeWrapper<APSInt>($Clone(X));
       });
      APSIntSet.InsertNode(P, InsertPos.$deref());
    }
    
    return $Deref(P.$T$R());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 89,
   FQN="clang::ento::BasicValueFactory::getValue", NM="_ZN5clang4ento17BasicValueFactory8getValueERKN4llvm5APIntEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory8getValueERKN4llvm5APIntEb")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getValue(final /*const*/ APInt /*&*/ X, 
          boolean isUnsigned) {
    APSInt V/*J*/= new APSInt(new APInt(X), isUnsigned);
    return getValue(V);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 102,
   FQN="clang::ento::BasicValueFactory::getValue", NM="_ZN5clang4ento17BasicValueFactory8getValueEyNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory8getValueEyNS_8QualTypeE")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getValue(long/*uint64_t*/ X, QualType T) {
    
    return getValue(getAPSIntType(new QualType(T)).getValue(X));
  }

  
  /// Returns the type of the APSInt used to store values of the given QualType.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getAPSIntType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 95,
   FQN="clang::ento::BasicValueFactory::getAPSIntType", NM="_ZNK5clang4ento17BasicValueFactory13getAPSIntTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZNK5clang4ento17BasicValueFactory13getAPSIntTypeENS_8QualTypeE")
  //</editor-fold>
  public APSIntType getAPSIntType(QualType T) /*const*/ {
    assert (T.$arrow().isIntegralOrEnumerationType() || Loc.isLocType(new QualType(T)));
    return new APSIntType($ulong2uint(Ctx.getTypeSize(new QualType(T))), 
        !T.$arrow().isSignedIntegerOrEnumerationType());
  }

  
  /// Convert - Create a new persistent APSInt with the same value as 'From'
  ///  but with the bitwidth and signedness of 'To'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::Convert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 103,
   FQN="clang::ento::BasicValueFactory::Convert", NM="_ZN5clang4ento17BasicValueFactory7ConvertERKN4llvm6APSIntES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory7ConvertERKN4llvm6APSIntES5_")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ Convert(final /*const*/ APSInt /*&*/ To, 
         final /*const*/ APSInt /*&*/ From) {
    APSIntType TargetType/*J*/= new APSIntType(To);
    if (TargetType.$eq(new APSIntType(From))) {
      return From;
    }
    
    return getValue(TargetType.convert(From));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::Convert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 112,
   FQN="clang::ento::BasicValueFactory::Convert", NM="_ZN5clang4ento17BasicValueFactory7ConvertENS_8QualTypeERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory7ConvertENS_8QualTypeERKN4llvm6APSIntE")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ Convert(QualType T, final /*const*/ APSInt /*&*/ From) {
    APSIntType TargetType = getAPSIntType(new QualType(T));
    if (TargetType.$eq(new APSIntType(From))) {
      return From;
    }
    
    return getValue(TargetType.convert(From));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getIntValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 120,
   FQN="clang::ento::BasicValueFactory::getIntValue", NM="_ZN5clang4ento17BasicValueFactory11getIntValueEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory11getIntValueEyb")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ getIntValue(long/*uint64_t*/ X, boolean isUnsigned) {
    QualType T = (isUnsigned ? Ctx.UnsignedIntTy : Ctx.IntTy).$QualType();
    return getValue(X, new QualType(T));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 125,
   FQN="clang::ento::BasicValueFactory::getMaxValue", NM="_ZN5clang4ento17BasicValueFactory11getMaxValueERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory11getMaxValueERKN4llvm6APSIntE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getMaxValue(final /*const*/ APSInt /*&*/ v) {
    return getValue(new APSIntType(v).getMaxValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 129,
   FQN="clang::ento::BasicValueFactory::getMinValue", NM="_ZN5clang4ento17BasicValueFactory11getMinValueERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory11getMinValueERKN4llvm6APSIntE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getMinValue(final /*const*/ APSInt /*&*/ v) {
    return getValue(new APSIntType(v).getMinValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getMaxValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 133,
   FQN="clang::ento::BasicValueFactory::getMaxValue", NM="_ZN5clang4ento17BasicValueFactory11getMaxValueENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory11getMaxValueENS_8QualTypeE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getMaxValue(QualType T) {
    return getValue(getAPSIntType(new QualType(T)).getMaxValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getMinValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 137,
   FQN="clang::ento::BasicValueFactory::getMinValue", NM="_ZN5clang4ento17BasicValueFactory11getMinValueENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory11getMinValueENS_8QualTypeE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getMinValue(QualType T) {
    return getValue(getAPSIntType(new QualType(T)).getMinValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::Add1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 141,
   FQN="clang::ento::BasicValueFactory::Add1", NM="_ZN5clang4ento17BasicValueFactory4Add1ERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory4Add1ERKN4llvm6APSIntE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ Add1(final /*const*/ APSInt /*&*/ V) {
    APSInt X = new APSInt(V);
    X.$preInc();
    return getValue(X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::Sub1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 147,
   FQN="clang::ento::BasicValueFactory::Sub1", NM="_ZN5clang4ento17BasicValueFactory4Sub1ERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory4Sub1ERKN4llvm6APSIntE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ Sub1(final /*const*/ APSInt /*&*/ V) {
    APSInt X = new APSInt(V);
    X.$preDec();
    return getValue(X);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getZeroWithPtrWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 153,
   FQN="clang::ento::BasicValueFactory::getZeroWithPtrWidth", NM="_ZN5clang4ento17BasicValueFactory19getZeroWithPtrWidthEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory19getZeroWithPtrWidthEb")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getZeroWithPtrWidth() {
    return getZeroWithPtrWidth(true);
  }
  public /*inline*/ /*const*/ APSInt /*&*/ getZeroWithPtrWidth(boolean isUnsigned/*= true*/) {
    return getValue($int2ulong(0), $ulong2uint(Ctx.getTypeSize(Ctx.VoidPtrTy.$QualType())), isUnsigned);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getIntWithPtrWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 157,
   FQN="clang::ento::BasicValueFactory::getIntWithPtrWidth", NM="_ZN5clang4ento17BasicValueFactory18getIntWithPtrWidthEyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory18getIntWithPtrWidthEyb")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getIntWithPtrWidth(long/*uint64_t*/ X, boolean isUnsigned) {
    return getValue(X, $ulong2uint(Ctx.getTypeSize(Ctx.VoidPtrTy.$QualType())), isUnsigned);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getTruthValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 161,
   FQN="clang::ento::BasicValueFactory::getTruthValue", NM="_ZN5clang4ento17BasicValueFactory13getTruthValueEbNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory13getTruthValueEbNS_8QualTypeE")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getTruthValue(boolean b, QualType T) {
    return getValue($int2ulong(b ? 1 : 0), $ulong2uint(Ctx.getTypeSize(new QualType(T))), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getTruthValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 165,
   FQN="clang::ento::BasicValueFactory::getTruthValue", NM="_ZN5clang4ento17BasicValueFactory13getTruthValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory13getTruthValueEb")
  //</editor-fold>
  public /*inline*/ /*const*/ APSInt /*&*/ getTruthValue(boolean b) {
    return getTruthValue(b, Ctx.getLogicalOperationType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getCompoundValData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 107,
   FQN="clang::ento::BasicValueFactory::getCompoundValData", NM="_ZN5clang4ento17BasicValueFactory18getCompoundValDataENS_8QualTypeEN4llvm13ImmutableListINS0_4SValEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory18getCompoundValDataENS_8QualTypeEN4llvm13ImmutableListINS0_4SValEEE")
  //</editor-fold>
  public /*const*/ CompoundValData /*P*/ getCompoundValData(QualType T, 
                    ImmutableList<SVal> Vals) {
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CompoundValData.Profile(ID, /*NO_COPY*/T, /*NO_COPY*/Vals);
    final type$ref<type$ptr<CompoundValData /*P*/>/*void P*/ > InsertPos = create_type$ref();
    
    CompoundValData /*P*/ D = CompoundValDataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(D != null)) {
      D = (CompoundValData /*P*/ )BPAlloc.<CompoundValData>Allocate$T(CompoundValData.class);
      /*NEW_EXPR [System]*/D = /*new (D)*/ $new_uint_voidPtr(D, (type$ptr<?> New$Mem)->{
          return new CompoundValData(new QualType(T), new ImmutableList<SVal>(Vals));
       });
      CompoundValDataSet.InsertNode(D, InsertPos.$deref());
    }
    
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getLazyCompoundValData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 126,
   FQN="clang::ento::BasicValueFactory::getLazyCompoundValData", NM="_ZN5clang4ento17BasicValueFactory22getLazyCompoundValDataERKNS0_8StoreRefEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory22getLazyCompoundValDataERKNS0_8StoreRefEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public /*const*/ LazyCompoundValData /*P*/ getLazyCompoundValData(final /*const*/ StoreRef /*&*/ store, 
                        /*const*/ TypedValueRegion /*P*/ region) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    LazyCompoundValData.Profile(ID, store, region);
    final type$ref<type$ptr<LazyCompoundValData /*P*/>/*void P*/ > InsertPos = create_type$ref();
    
    LazyCompoundValData /*P*/ D = LazyCompoundValDataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(D != null)) {
      D = (LazyCompoundValData /*P*/ )BPAlloc.<LazyCompoundValData>Allocate$T(LazyCompoundValData.class);
      /*NEW_EXPR [System]*/D = /*new (D)*/ $new_uint_voidPtr(D, (type$ptr<?> New$Mem)->{
          return new LazyCompoundValData(store, region);
       });
      LazyCompoundValDataSet.InsertNode(D, InsertPos.$deref());
    }
    
    return D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getEmptySValList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 175,
   FQN="clang::ento::BasicValueFactory::getEmptySValList", NM="_ZN5clang4ento17BasicValueFactory16getEmptySValListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory16getEmptySValListEv")
  //</editor-fold>
  public ImmutableList<SVal> getEmptySValList() {
    return SValListFactory.getEmptyList();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::consVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BasicValueFactory.h", line = 179,
   FQN="clang::ento::BasicValueFactory::consVals", NM="_ZN5clang4ento17BasicValueFactory8consValsENS0_4SValEN4llvm13ImmutableListIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory8consValsENS0_4SValEN4llvm13ImmutableListIS2_EE")
  //</editor-fold>
  public ImmutableList<SVal> consVals(SVal X, ImmutableList<SVal> L) {
    return SValListFactory.add(X, new ImmutableList<SVal>(L));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::evalAPSInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 145,
   FQN="clang::ento::BasicValueFactory::evalAPSInt", NM="_ZN5clang4ento17BasicValueFactory10evalAPSIntENS_18BinaryOperatorKindERKN4llvm6APSIntES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory10evalAPSIntENS_18BinaryOperatorKindERKN4llvm6APSIntES6_")
  //</editor-fold>
  public /*const*/ APSInt /*P*/ evalAPSInt(BinaryOperatorKind Op, 
            final /*const*/ APSInt /*&*/ V1, final /*const*/ APSInt /*&*/ V2) {
    switch (Op) {
     default:
      assert (false) : "Invalid Opcode.";
     case BO_Mul:
      return $AddrOf(getValue(V1.$star(V2)));
     case BO_Div:
      if (V2.$eq(0)) { // Avoid division by zero
        return null;
      }
      return $AddrOf(getValue(V1.$slash(V2)));
     case BO_Rem:
      if (V2.$eq(0)) { // Avoid division by zero
        return null;
      }
      return $AddrOf(getValue(V1.$mod(V2)));
     case BO_Add:
      return $AddrOf(getValue(V1.$add(V2)));
     case BO_Sub:
      return $AddrOf(getValue(V1.$sub(V2)));
     case BO_Shl:
      {
        
        // FIXME: This logic should probably go higher up, where we can
        // test these conditions symbolically.
        
        // FIXME: Expand these checks to include all undefined behavior.
        if (V2.isSigned() && V2.isNegative()) {
          return null;
        }
        
        long/*uint64_t*/ Amt = V2.getZExtValue();
        if ($greatereq_ulong_uint(Amt, V1.getBitWidth())) {
          return null;
        }
        
        return $AddrOf(getValue(V1.$out((/*uint*/int)$ulong2uint(Amt))));
      }
     case BO_Shr:
      {
        
        // FIXME: This logic should probably go higher up, where we can
        // test these conditions symbolically.
        
        // FIXME: Expand these checks to include all undefined behavior.
        if (V2.isSigned() && V2.isNegative()) {
          return null;
        }
        
        long/*uint64_t*/ Amt = V2.getZExtValue();
        if ($greatereq_ulong_uint(Amt, V1.getBitWidth())) {
          return null;
        }
        
        return $AddrOf(getValue(V1.$in((/*uint*/int)$ulong2uint(Amt))));
      }
     case BO_LT:
      return $AddrOf(getTruthValue(V1.$less(V2)));
     case BO_GT:
      return $AddrOf(getTruthValue(V1.$greater(V2)));
     case BO_LE:
      return $AddrOf(getTruthValue(V1.$lesseq(V2)));
     case BO_GE:
      return $AddrOf(getTruthValue(V1.$greatereq(V2)));
     case BO_EQ:
      return $AddrOf(getTruthValue(V1.$eq(V2)));
     case BO_NE:
      return $AddrOf(getTruthValue(V1.$noteq(V2)));
     case BO_And:
      
      // Note: LAnd, LOr, Comma are handled specially by higher-level logic.
      return $AddrOf(getValue(V1.$bitand(V2)));
     case BO_Or:
      return $AddrOf(getValue(V1.$bitor(V2)));
     case BO_Xor:
      return $AddrOf(getValue(V1.$bitxor(V2)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getPersistentSValWithData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pass uint, clone for FoldingSetNodeWrapper*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 240,
   FQN="clang::ento::BasicValueFactory::getPersistentSValWithData", NM="_ZN5clang4ento17BasicValueFactory25getPersistentSValWithDataERKNS0_4SValEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory25getPersistentSValWithDataERKNS0_4SValEj")
  //</editor-fold>
  public /*const*/std.pairTypeUInt<SVal> /*&*/ getPersistentSValWithData(final /*const*/ SVal /*&*/ V, int/*uintptr_t*/ Data) {
    
    // Lazily create the folding set.
    if (!(PersistentSVals != null)) {
      PersistentSVals = new FoldingSet<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >>(FoldingSetNodeWrapper.$Trait());
    }
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    final type$ref<type$ptr<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> > /*P*/>/*void P*/ > InsertPos = create_type$ref();
    V.Profile(ID);
    ID./*JAVA*/AddInteger_uint(Data);
    
    final FoldingSet<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >> /*&*/ Map = $Deref(((FoldingSet<FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >> /*P*/)PersistentSVals));
    
    /*typedef llvm::FoldingSetNodeWrapper<SValData> FoldNodeTy*/
  //  final class FoldNodeTy extends FoldingSetNodeWrapper<std.pairTypeUInt<SVal> >{ };
    FoldingSetNodeWrapper<std.pairTypeUInt<SVal> > /*P*/ P = Map.FindNodeOrInsertPos(ID, InsertPos);
    if (!(P != null)) {
      P = (FoldingSetNodeWrapper<std.pairTypeUInt<SVal> > /*P*/ )BPAlloc.<FoldingSetNodeWrapper>Allocate$T(FoldingSetNodeWrapper.class);
      /*NEW_EXPR [System]*/P = /*new (P)*/ $new_uint_voidPtr(P, (type$ptr<?> New$Mem)->{
          return new FoldingSetNodeWrapper(std.make_pair_T_uint/*JAVA*/($Clone(V), Data));
       });
      Map.InsertNode(P, InsertPos.$deref());
    }
    
    return P.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getPersistentSValPair">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clone for FoldingSetNodeWrapper*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 265,
   FQN="clang::ento::BasicValueFactory::getPersistentSValPair", NM="_ZN5clang4ento17BasicValueFactory21getPersistentSValPairERKNS0_4SValES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory21getPersistentSValPairERKNS0_4SValES4_")
  //</editor-fold>
  public /*const*/ std.pairTypeType<SVal, SVal> /*&*/ getPersistentSValPair(final /*const*/ SVal /*&*/ V1, final /*const*/ SVal /*&*/ V2) {
    
    // Lazily create the folding set.
    if (!(PersistentSValPairs != null)) {
      PersistentSValPairs = new FoldingSet<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >>(FoldingSetNodeWrapper.$Trait());
    }
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    final type$ref<type$ptr<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> > /*P*/>/*void P*/ > InsertPos = create_type$ref();
    V1.Profile(ID);
    V2.Profile(ID);
    
    final FoldingSet<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >> /*&*/ Map = $Deref(((FoldingSet<FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >> /*P*/)PersistentSValPairs));
    
    /*typedef llvm::FoldingSetNodeWrapper<SValPair> FoldNodeTy*/
//    final class FoldNodeTy extends FoldingSetNodeWrapper<std.pair<SVal, SVal> >{ };
    FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> > /*P*/ P = Map.FindNodeOrInsertPos(ID, InsertPos);
    if (!(P != null)) {
      P = (FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> > /*P*/ )BPAlloc.<FoldingSetNodeWrapper>Allocate$T(FoldingSetNodeWrapper.class);
      /*NEW_EXPR [System]*/P = /*new (P)*/ $new_uint_voidPtr(P, (type$ptr<?> New$Mem)->{
          return new FoldingSetNodeWrapper<std.pairTypeType<SVal, SVal> >(std.make_pair($Clone(V1), $Clone(V2)));
       });
      Map.InsertNode(P, InsertPos.$deref());
    }
    
    return P.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BasicValueFactory::getPersistentSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp", line = 290,
   FQN="clang::ento::BasicValueFactory::getPersistentSVal", NM="_ZN5clang4ento17BasicValueFactory17getPersistentSValENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BasicValueFactory.cpp -nm=_ZN5clang4ento17BasicValueFactory17getPersistentSValENS0_4SValE")
  //</editor-fold>
  public /*const*/ SVal /*P*/ getPersistentSVal(SVal X) {
    return $AddrOf(getPersistentSValWithData(X, 0).first);
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", BPAlloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", APSIntSet=" + APSIntSet // NOI18N
              + ", PersistentSVals=" + PersistentSVals // NOI18N
              + ", PersistentSValPairs=" + PersistentSValPairs // NOI18N
              + ", SValListFactory=" + SValListFactory // NOI18N
              + ", CompoundValDataSet=" + CompoundValDataSet // NOI18N
              + ", LazyCompoundValDataSet=" + LazyCompoundValDataSet; // NOI18N
  }
}
