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
import org.clang.staticanalyzer.checkers.impl.java.ProgramStatePartialTrait;


// Partial-specialization for ImmutableList.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 152,
 FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEEE")
//</editor-fold>
public abstract class/*struct*/ ProgramStatePartialTraitImmutableList$T</*typename*/ Key>  implements ProgramStatePartialTrait<ImmutableList<Key>> {
  /*typedef llvm::ImmutableList<T> data_type*/
//  public final class data_type extends ImmutableList<T>{ };
  /*typedef T key_type*/
//  public final class key_type extends T{ };
  /*typedef typename data_type::Factory &context_type*/
//  public final class context_type extends  ImmutableList.Factory<T> /*&*/ { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::Add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 158,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::Add", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE3AddES5_S4_RNS5_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE3AddES5_S4_RNS5_7FactoryE")
  //</editor-fold>
  public ImmutableList<Key> Add(ImmutableList<Key> L, Key K, final  ImmutableListFactory<Key> /*&*/ F) {
    return F.add(K, L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::Contains">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 162,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::Contains", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE8ContainsES5_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE8ContainsES5_S4_")
  //</editor-fold>
  public boolean Contains(ImmutableList<Key> L, Key K) {
    return L.contains(K);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 166,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeData", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE8MakeDataEPKPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE8MakeDataEPKPv")
  //</editor-fold>
  public ImmutableList<Key> MakeData(type$ptr<Object>/*void P const P*/ p) {
    return Native.$bool(p) ? new ImmutableList<Key>((/*const*/ ImmutableListImpl<Key> /*P*/ )p.$star()) : new ImmutableList<Key>((ImmutableListImpl<Key>)null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeVoidPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 171,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeVoidPtr", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE11MakeVoidPtrES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE11MakeVoidPtrES5_")
  //</editor-fold>
  public Object/*void P*/ MakeVoidPtr(ImmutableList<Key> D) {
    return ((/*const_cast*/ImmutableListImpl<Key> /*P*/ )(D.getInternalPointer()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 175,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::MakeContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE11MakeContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE11MakeContextEPv")
  //</editor-fold>
  public ImmutableListFactory<Key> /*&*/ MakeContext(Object/*void P*/ p) {
    return Native.$star((( ImmutableListFactory<Key> /*P*/ )p));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::CreateContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 179,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::CreateContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public Object/*void P*/ CreateContext(final BumpPtrAllocatorImpl /*&*/ Alloc) {
    return new  ImmutableListFactory<Key>(( Alloc ));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::DeleteContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 183,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableList<type-parameter-0-0> >::DeleteContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE13DeleteContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm13ImmutableListIT_EEE13DeleteContextEPv")
  //</editor-fold>
  public void DeleteContext(Object/*void P*/ Ctx) {
    /*delete*/Destructors.$destroy(( ImmutableListFactory<Key> /*P*/ )Ctx);
  }

  public Key $tryCloneKey(Key K) {
    throw new UnsupportedOperationException("Why not implemented in derived " + this.getClass());
  }

  @Override
  public ImmutableList<Key> $tryCloneData(JavaCleaner $c$, ImmutableList<Key> D) {
    return $c$.track(Native.$Clone(D));
  }
    
  @Override public String toString() {
    return ""; // NOI18N
  }
}
