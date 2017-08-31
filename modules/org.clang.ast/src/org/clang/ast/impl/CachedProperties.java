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

package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief The cached properties of a type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3218,
 FQN="(anonymous namespace)::CachedProperties", NM="_ZN12_GLOBAL__N_116CachedPropertiesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_116CachedPropertiesE")
//</editor-fold>
public class CachedProperties {
  private Linkage L;
  private boolean local;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::CachedProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3223,
   FQN="(anonymous namespace)::CachedProperties::CachedProperties", NM="_ZN12_GLOBAL__N_116CachedPropertiesC1EN5clang7LinkageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_116CachedPropertiesC1EN5clang7LinkageEb")
  //</editor-fold>
  public CachedProperties(Linkage L, boolean local) {
    // : L(L), local(local) 
    //START JInit
    this.L = L;
    this.local = local;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::getLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3225,
   FQN="(anonymous namespace)::CachedProperties::getLinkage", NM="_ZNK12_GLOBAL__N_116CachedProperties10getLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK12_GLOBAL__N_116CachedProperties10getLinkageEv")
  //</editor-fold>
  public Linkage getLinkage() /*const*/ {
    return L;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::hasLocalOrUnnamedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3226,
   FQN="(anonymous namespace)::CachedProperties::hasLocalOrUnnamedType", NM="_ZNK12_GLOBAL__N_116CachedProperties21hasLocalOrUnnamedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK12_GLOBAL__N_116CachedProperties21hasLocalOrUnnamedTypeEv")
  //</editor-fold>
  public boolean hasLocalOrUnnamedType() /*const*/ {
    return local;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::merge">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3228,
   FQN="(anonymous namespace)::merge", NM="_ZN12_GLOBAL__N_15mergeENS_16CachedPropertiesES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_15mergeENS_16CachedPropertiesES0_")
  //</editor-fold>
  public static CachedProperties merge(CachedProperties L, CachedProperties R) {
    Linkage MergedLinkage = minLinkage(L.L, R.L);
    return new CachedProperties(MergedLinkage, 
        L.hasLocalOrUnnamedType() || R.hasLocalOrUnnamedType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::CachedProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3218,
   FQN="(anonymous namespace)::CachedProperties::CachedProperties", NM="_ZN12_GLOBAL__N_116CachedPropertiesC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_116CachedPropertiesC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CachedProperties(final /*const*/ CachedProperties /*&*/ $Prm0) {
    // : L(.L), local(.local) 
    //START JInit
    this.L = $Prm0.L;
    this.local = $Prm0.local;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::CachedProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3218,
   FQN="(anonymous namespace)::CachedProperties::CachedProperties", NM="_ZN12_GLOBAL__N_116CachedPropertiesC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_116CachedPropertiesC1EOS0_")
  //</editor-fold>
  public /*inline*/ CachedProperties(JD$Move _dparam, final CachedProperties /*&&*/$Prm0) {
    // : L(static_cast<CachedProperties &&>().L), local(static_cast<CachedProperties &&>().local) 
    //START JInit
    this.L = $Prm0.L;
    this.local = $Prm0.local;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CachedProperties::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3218,
   FQN="(anonymous namespace)::CachedProperties::operator=", NM="_ZN12_GLOBAL__N_116CachedPropertiesaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN12_GLOBAL__N_116CachedPropertiesaSEOS0_")
  //</editor-fold>
  public /*inline*/ CachedProperties /*&*/ $assignMove(final CachedProperties /*&&*/$Prm0) {
    this.L = $Prm0.L;
    this.local = $Prm0.local;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "L=" + L // NOI18N
              + ", local=" + local; // NOI18N
  }
}
