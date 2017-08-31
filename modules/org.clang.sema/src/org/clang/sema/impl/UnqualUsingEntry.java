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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, /*generated with temporary mapping in the file org.clang.sema/llvmToClangType:
                                                    const DeclContext * = type$ptr<DeclContext>*/
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 59,
 FQN="(anonymous namespace)::UnqualUsingEntry", NM="_ZN12_GLOBAL__N_116UnqualUsingEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntryE")
//</editor-fold>
public class UnqualUsingEntry implements NativeCloneable<UnqualUsingEntry> {
  private DeclContext/*P*/ Nominated;
  private DeclContext/*P*/ CommonAncestor;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::UnqualUsingEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 64,
   FQN="(anonymous namespace)::UnqualUsingEntry::UnqualUsingEntry", NM="_ZN12_GLOBAL__N_116UnqualUsingEntryC1EPKN5clang11DeclContextES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntryC1EPKN5clang11DeclContextES4_")
  //</editor-fold>
  public UnqualUsingEntry(DeclContext /*P*/ Nominated, 
      DeclContext /*P*/ CommonAncestor) {
    // : Nominated(Nominated), CommonAncestor(CommonAncestor) 
    //START JInit
    this.Nominated = Nominated;
    this.CommonAncestor = CommonAncestor;
    //END JInit
  }

  UnqualUsingEntry() {
    Nominated = null;
    CommonAncestor = null;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::getCommonAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 69,
   FQN="(anonymous namespace)::UnqualUsingEntry::getCommonAncestor", NM="_ZNK12_GLOBAL__N_116UnqualUsingEntry17getCommonAncestorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK12_GLOBAL__N_116UnqualUsingEntry17getCommonAncestorEv")
  //</editor-fold>
  public DeclContext /*P*/ getCommonAncestor() /*const*/ {
    return CommonAncestor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::getNominatedNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 73,
   FQN="(anonymous namespace)::UnqualUsingEntry::getNominatedNamespace", NM="_ZNK12_GLOBAL__N_116UnqualUsingEntry21getNominatedNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK12_GLOBAL__N_116UnqualUsingEntry21getNominatedNamespaceEv")
  //</editor-fold>
  public DeclContext /*P*/ getNominatedNamespace() /*const*/ {
    return Nominated;
  }

  
  // Sort by the pointer value of the common ancestor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 78,
   FQN="(anonymous namespace)::UnqualUsingEntry::Comparator", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorE")
  //</editor-fold>
  public static class/*struct*/ Comparator implements Compare {

    Comparator() {
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 79,
     FQN="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclERKS0_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclERKS0_S3_")
    //</editor-fold>
    public boolean $call(final /*const*/ UnqualUsingEntry /*&*/ L, final /*const*/ UnqualUsingEntry /*&*/ R) {
      return Native.$less$JavaRef(L.getCommonAncestor(), R.getCommonAncestor());
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 83,
     FQN="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclERKS0_PKN5clang11DeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclERKS0_PKN5clang11DeclContextE")
    //</editor-fold>
    public boolean $call(final /*const*/ UnqualUsingEntry /*&*/ E, DeclContext /*P*/ DC) {
      return Native.$less$JavaRef(E.getCommonAncestor(), DC);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 87,
     FQN="(anonymous namespace)::UnqualUsingEntry::Comparator::operator()", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclEPKN5clang11DeclContextERKS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorclEPKN5clang11DeclContextERKS0_")
    //</editor-fold>
    public boolean $call(DeclContext /*P*/ DC, final /*const*/ UnqualUsingEntry /*&*/ E) {
      return Native.$less$JavaRef(DC, E.getCommonAncestor());
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator::Comparator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 78,
     FQN="(anonymous namespace)::UnqualUsingEntry::Comparator::Comparator", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Comparator(final /*const*/ Comparator /*&*/ $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::Comparator::Comparator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 78,
     FQN="(anonymous namespace)::UnqualUsingEntry::Comparator::Comparator", NM="_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntry10ComparatorC1EOS1_")
    //</editor-fold>
    public /*inline*/ Comparator(JD$Move _dparam, final Comparator /*&&*/$Prm0) {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }

    @Override
    public boolean compare(Object a, Object b) {
      if (a instanceof UnqualUsingEntry) {
        if (b instanceof UnqualUsingEntry) {
          return $call((UnqualUsingEntry)a, (UnqualUsingEntry)b);
        }
        return $call((UnqualUsingEntry)a, (DeclContext/*P*/)b);
      } else {
        assert b instanceof UnqualUsingEntry : b.getClass();
        return $call((DeclContext/*P*/)a, (UnqualUsingEntry)b);
      }
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::UnqualUsingEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 59,
   FQN="(anonymous namespace)::UnqualUsingEntry::UnqualUsingEntry", NM="_ZN12_GLOBAL__N_116UnqualUsingEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ UnqualUsingEntry(JD$Move _dparam, final UnqualUsingEntry /*&&*/$Prm0) {
    // : Nominated(static_cast<UnqualUsingEntry &&>().Nominated), CommonAncestor(static_cast<UnqualUsingEntry &&>().CommonAncestor) 
    //START JInit
    this.Nominated = $Prm0.Nominated;
    this.CommonAncestor = $Prm0.CommonAncestor;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnqualUsingEntry::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 59,
   FQN="(anonymous namespace)::UnqualUsingEntry::operator=", NM="_ZN12_GLOBAL__N_116UnqualUsingEntryaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN12_GLOBAL__N_116UnqualUsingEntryaSEOS0_")
  //</editor-fold>
  public /*inline*/ UnqualUsingEntry /*&*/ $assignMove(final UnqualUsingEntry /*&&*/$Prm0) {
    this.Nominated = $Prm0.Nominated;
    this.CommonAncestor = $Prm0.CommonAncestor;
    return /*Deref*/this;
  }

  public UnqualUsingEntry(final UnqualUsingEntry $Prm0) { this($Prm0.Nominated, $Prm0.CommonAncestor); }
  @Override public UnqualUsingEntry clone() { return new UnqualUsingEntry(this); }
  
  @Override public String toString() {
    return "" + "Nominated=" + NativeTrace.getIdentityStr(Nominated) // NOI18N
              + ", CommonAncestor=" + NativeTrace.getIdentityStr(CommonAncestor); // NOI18N
  }
}
