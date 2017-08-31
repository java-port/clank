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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


/// An exceptions scope which filters exceptions thrown through it.
/// Only exceptions matching the filter types will be permitted to be
/// thrown.
///
/// This is used to implement C++ exception specifications.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 439,
 FQN="clang::CodeGen::EHFilterScope", NM="_ZN5clang7CodeGen13EHFilterScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScopeE")
//</editor-fold>
public class EHFilterScope extends /*public*/ EHScope {
  // Essentially ends in a flexible array member:
  // llvm::Value *FilterTypes[0];
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::getFilters">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 443,
   FQN="clang::CodeGen::EHFilterScope::getFilters", NM="_ZN5clang7CodeGen13EHFilterScope10getFiltersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScope10getFiltersEv")
  //</editor-fold>
  private type$ptr<Value /*P*/ /*P*/> getFilters() {
    return $tryClone($this_plus_1);//((type$ptr<Value /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::getFilters">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 447,
   FQN="clang::CodeGen::EHFilterScope::getFilters", NM="_ZNK5clang7CodeGen13EHFilterScope10getFiltersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen13EHFilterScope10getFiltersEv")
  //</editor-fold>
  private type$ptr<Value /*P*/ /*const*/ /*P*/> getFilters$Const() /*const*/ {
    return $tryClone($this_plus_1);//((type$ptr<Value /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, this + 1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::EHFilterScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 452,
   FQN="clang::CodeGen::EHFilterScope::EHFilterScope", NM="_ZN5clang7CodeGen13EHFilterScopeC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScopeC1Ej")
  //</editor-fold>
  public EHFilterScope(/*uint*/int numFilters) {
    // : EHScope(Filter, EHScopeStack::stable_end()) 
    //START JInit
    /*ExprWithCleanups*/super(Kind.Filter, EHScopeStack.stable_end());
    //END JInit
    Unnamed_field3.FilterBits.NumFilters = numFilters;
    assert (Unnamed_field3.FilterBits.NumFilters == numFilters) : "NumFilters overflow";
    $this_plus_1 = create_type$ptr(new Value[numFilters]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::getSizeForNumFilters">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 458,
   FQN="clang::CodeGen::EHFilterScope::getSizeForNumFilters", NM="_ZN5clang7CodeGen13EHFilterScope20getSizeForNumFiltersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScope20getSizeForNumFiltersEj")
  //</editor-fold>
  public static /*size_t*/int getSizeForNumFilters(/*uint*/int numFilters) {
    return 1/*JAVA*//*$sizeof_EHFilterScope()*/ + numFilters * 1/*JAVA*//*$sizeof_ptr(Value  )*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::getNumFilters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 462,
   FQN="clang::CodeGen::EHFilterScope::getNumFilters", NM="_ZNK5clang7CodeGen13EHFilterScope13getNumFiltersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen13EHFilterScope13getNumFiltersEv")
  //</editor-fold>
  public /*uint*/int getNumFilters() /*const*/ {
    return Unnamed_field3.FilterBits.NumFilters;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::setFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 464,
   FQN="clang::CodeGen::EHFilterScope::setFilter", NM="_ZN5clang7CodeGen13EHFilterScope9setFilterEjPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScope9setFilterEjPN4llvm5ValueE")
  //</editor-fold>
  public void setFilter(/*uint*/int i, Value /*P*/ filterValue) {
    assert ($less_uint(i, getNumFilters()));
    getFilters().$set(i, filterValue);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::getFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 469,
   FQN="clang::CodeGen::EHFilterScope::getFilter", NM="_ZNK5clang7CodeGen13EHFilterScope9getFilterEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen13EHFilterScope9getFilterEj")
  //</editor-fold>
  public Value /*P*/ getFilter(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumFilters()));
    return getFilters$Const().$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHFilterScope::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 474,
   FQN="clang::CodeGen::EHFilterScope::classof", NM="_ZN5clang7CodeGen13EHFilterScope7classofEPKNS0_7EHScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen13EHFilterScope7classofEPKNS0_7EHScopeE")
  //</editor-fold>
  public static boolean classof(/*const*/ EHScope /*P*/ scope) {
    return scope.getKind() == Kind.Filter;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<Value> $this_plus_1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
