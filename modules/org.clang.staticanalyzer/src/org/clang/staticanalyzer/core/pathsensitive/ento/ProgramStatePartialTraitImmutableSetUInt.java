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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.checkers.impl.java.ProgramStatePartialTrait;


// Partial-specialization for ImmutableSet.
/*template <typename Key, typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 109,
 FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEEE")
//</editor-fold>
public abstract class/*struct*/ ProgramStatePartialTraitImmutableSetUInt implements ProgramStatePartialTrait<ImmutableSetUInt>  {
  /*typedef llvm::ImmutableSet<Key, Info> data_type*/
//  public final class data_type extends ImmutableSetUInt{ };
  /*typedef typename data_type::Factory &context_type*/
//  public final class context_type extends  ImmutableSetUInt.Factory /*&*/ { };
  /*typedef Key key_type*/
//  public final class key_type extends Key{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 115,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeData", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE8MakeDataEPKPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE8MakeDataEPKPv")
  //</editor-fold>
  public /*inline*/ ImmutableSetUInt MakeData(type$ptr<Object>/*void P const P*/ p) {
    return Native.$bool(p) ? new ImmutableSetUInt(( ImutAVLTreeUIntBoolUInt /*P*/ )p.$star()) : new ImmutableSetUInt((ImutAVLTreeUIntBoolUInt)null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeVoidPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 120,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeVoidPtr", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE11MakeVoidPtrES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE11MakeVoidPtrES6_")
  //</editor-fold>
  public Object/*void P*/ MakeVoidPtr(ImmutableSetUInt B) {
    return B.getRoot();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 124,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Add", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE3AddES6_S4_RNS6_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE3AddES6_S4_RNS6_7FactoryE")
  //</editor-fold>
  public ImmutableSetUInt Add(ImmutableSetUInt B, /*uint Key*/int K, final  ImmutableSetUInt.Factory /*&*/ F) {
    return F.add(B, K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 128,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Remove", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE6RemoveES6_S4_RNS6_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE6RemoveES6_S4_RNS6_7FactoryE")
  //</editor-fold>
  public ImmutableSetUInt Remove(ImmutableSetUInt B, /*uint Key*/int K, final  ImmutableSetUInt.Factory /*&*/ F) {
    return F.remove(B, K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Contains">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 132,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::Contains", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE8ContainsES6_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE8ContainsES6_S4_")
  //</editor-fold>
  public boolean Contains(ImmutableSetUInt B, /*uint Key*/int K) {
    return B.contains(K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 136,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::MakeContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE11MakeContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE11MakeContextEPv")
  //</editor-fold>
  public ImmutableSetUInt.Factory /*&*/ MakeContext(Object/*void P*/ p) {
    return Native.$star((( ImmutableSetUInt.Factory /*P*/ )p));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::CreateContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 140,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::CreateContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public Object/*void P*/ CreateContext(final BumpPtrAllocatorImpl /*&*/ Alloc) {
    return new ImmutableSetUInt.Factory($ValInfo, ( Alloc ));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::DeleteContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 144,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableSet<type-parameter-0-0, type-parameter-0-1> >::DeleteContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE13DeleteContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableSetIT_T0_EEE13DeleteContextEPv")
  //</editor-fold>
  public void DeleteContext(Object/*void P*/ Ctx) {
    /*delete*/Destructors.$destroy(( ImmutableSetUInt.Factory /*P*/ )Ctx);
  }

  public final /*uint Key*/int $tryCloneKey(/*uint Key*/int K) {
    return K;
  }

  @Override public final ImmutableSetUInt $tryCloneData(JavaCleaner $c$, ImmutableSetUInt D) {
    return $c$.track(Native.$Clone(D));
  }
    
  private final ImutContainerInfoUInt $ValInfo = ImutContainerInfoUInt.$Info();

  protected ProgramStatePartialTraitImmutableSetUInt() {
  }
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
