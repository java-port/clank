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

package org.clang.analysis.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.analysis.impl.UninitializedValuesStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 51,
 FQN="(anonymous namespace)::DeclToIndex", NM="_ZN12_GLOBAL__N_111DeclToIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_111DeclToIndexE")
//</editor-fold>
public class DeclToIndex implements Destructors.ClassWithDestructor {
  private DenseMapTypeUInt</*const*/ VarDecl /*P*/ > map;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex::DeclToIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 54,
   FQN="(anonymous namespace)::DeclToIndex::DeclToIndex", NM="_ZN12_GLOBAL__N_111DeclToIndexC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_111DeclToIndexC1Ev")
  //</editor-fold>
  public DeclToIndex() {
    // : map() 
    //START JInit
    this.map = new DenseMapTypeUInt</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  
  /// Compute the actual mapping from declarations to bits.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex::computeMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 67,
   FQN="(anonymous namespace)::DeclToIndex::computeMap", NM="_ZN12_GLOBAL__N_111DeclToIndex10computeMapERKN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_111DeclToIndex10computeMapERKN5clang11DeclContextE")
  //</editor-fold>
  public void computeMap(final /*const*/ DeclContext /*&*/ dc) {
    /*uint*/int count = 0;
    DeclContext.specific_decl_iterator<VarDecl> I/*J*/= new DeclContext.specific_decl_iterator<VarDecl>(VarDecl.class, dc.decls_begin());
    DeclContext.specific_decl_iterator<VarDecl> E/*J*/= new DeclContext.specific_decl_iterator<VarDecl>(VarDecl.class, dc.decls_end());
    for (; DeclContext.specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc()) {
      /*const*/ VarDecl /*P*/ vd = I.$star();
      if (isTrackedVar(vd, $AddrOf(dc))) {
        map.$set(vd, count++);
      }
    }
  }

  
  /// Return the number of declarations in the map.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 60,
   FQN="(anonymous namespace)::DeclToIndex::size", NM="_ZNK12_GLOBAL__N_111DeclToIndex4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_111DeclToIndex4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return map.size();
  }

  
  /// Returns the bit vector index for a given declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex::getValueIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 78,
   FQN="(anonymous namespace)::DeclToIndex::getValueIndex", NM="_ZNK12_GLOBAL__N_111DeclToIndex13getValueIndexEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_111DeclToIndex13getValueIndexEPKN5clang7VarDeclE")
  //</editor-fold>
  public OptionalUInt getValueIndex(/*const*/ VarDecl /*P*/ d) /*const*/ {
    DenseMapIteratorTypeUInt</*const*/ VarDecl /*P*/ /*P*/> I = map.find$Const(d);
    if (I.$eq(map.end$Const())) {
      return new OptionalUInt(None);
    }
    return new OptionalUInt(JD$T$C$R.INSTANCE, I.$arrow().second);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclToIndex::~DeclToIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 51,
   FQN="(anonymous namespace)::DeclToIndex::~DeclToIndex", NM="_ZN12_GLOBAL__N_111DeclToIndexD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_111DeclToIndexD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    map.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "map=" + map; // NOI18N
  }
}
