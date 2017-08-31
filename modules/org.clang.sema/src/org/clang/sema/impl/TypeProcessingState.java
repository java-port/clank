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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaTypeStatics.*;

/// An object which stores processing state for the entire
/// GetTypeForDeclarator process.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 141,
 FQN="(anonymous namespace)::TypeProcessingState", NM="_ZN12_GLOBAL__N_119TypeProcessingStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingStateE")
//</editor-fold>
public class TypeProcessingState implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ sema;
  
  /// The declarator being processed.
  private final Declarator /*&*/ declarator;
  
  /// The index of the declarator chunk we're currently processing.
  /// May be the total number of valid chunks, indicating the
  /// DeclSpec.
  private /*uint*/int chunkIndex;
  
  /// Whether there are non-trivial modifications to the decl spec.
  private boolean trivial;
  
  /// Whether we saved the attributes in the decl spec.
  private boolean hasSavedAttrs;
  
  /// The original set of attributes on the DeclSpec.
  private SmallVector<AttributeList /*P*/ > savedAttrs;
  
  /// A list of attributes to diagnose the uselessness of when the
  /// processing is complete.
  private SmallVector<AttributeList /*P*/ > ignoredTypeAttrs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::TypeProcessingState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 166,
   FQN="(anonymous namespace)::TypeProcessingState::TypeProcessingState", NM="_ZN12_GLOBAL__N_119TypeProcessingStateC1ERN5clang4SemaERNS1_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingStateC1ERN5clang4SemaERNS1_10DeclaratorE")
  //</editor-fold>
  public TypeProcessingState(final Sema /*&*/ sema, final Declarator /*&*/ declarator) {
    // : sema(sema), declarator(declarator), chunkIndex(declarator.getNumTypeObjects()), trivial(true), hasSavedAttrs(false), savedAttrs(), ignoredTypeAttrs() 
    //START JInit
    this./*&*/sema=/*&*/sema;
    this./*&*/declarator=/*&*/declarator;
    this.chunkIndex = declarator.getNumTypeObjects();
    this.trivial = true;
    this.hasSavedAttrs = false;
    this.savedAttrs = new SmallVector<AttributeList /*P*/ >(2, (AttributeList /*P*/ )null);
    this.ignoredTypeAttrs = new SmallVector<AttributeList /*P*/ >(2, (AttributeList /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::getSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 171,
   FQN="(anonymous namespace)::TypeProcessingState::getSema", NM="_ZNK12_GLOBAL__N_119TypeProcessingState7getSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState7getSemaEv")
  //</editor-fold>
  public Sema /*&*/ getSema() /*const*/ {
    return sema;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::getDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 175,
   FQN="(anonymous namespace)::TypeProcessingState::getDeclarator", NM="_ZNK12_GLOBAL__N_119TypeProcessingState13getDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState13getDeclaratorEv")
  //</editor-fold>
  public Declarator /*&*/ getDeclarator() /*const*/ {
    return declarator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::isProcessingDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 179,
   FQN="(anonymous namespace)::TypeProcessingState::isProcessingDeclSpec", NM="_ZNK12_GLOBAL__N_119TypeProcessingState20isProcessingDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState20isProcessingDeclSpecEv")
  //</editor-fold>
  public boolean isProcessingDeclSpec() /*const*/ {
    return chunkIndex == declarator.getNumTypeObjects();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::getCurrentChunkIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 183,
   FQN="(anonymous namespace)::TypeProcessingState::getCurrentChunkIndex", NM="_ZNK12_GLOBAL__N_119TypeProcessingState20getCurrentChunkIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState20getCurrentChunkIndexEv")
  //</editor-fold>
  public /*uint*/int getCurrentChunkIndex() /*const*/ {
    return chunkIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::setCurrentChunkIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 187,
   FQN="(anonymous namespace)::TypeProcessingState::setCurrentChunkIndex", NM="_ZN12_GLOBAL__N_119TypeProcessingState20setCurrentChunkIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingState20setCurrentChunkIndexEj")
  //</editor-fold>
  public void setCurrentChunkIndex(/*uint*/int idx) {
    assert ($lesseq_uint(idx, declarator.getNumTypeObjects()));
    chunkIndex = idx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::getCurrentAttrListRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 192,
   FQN="(anonymous namespace)::TypeProcessingState::getCurrentAttrListRef", NM="_ZNK12_GLOBAL__N_119TypeProcessingState21getCurrentAttrListRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState21getCurrentAttrListRefEv")
  //</editor-fold>
  public type$ref<AttributeList/*P*/>/*&*/ getCurrentAttrListRef() /*const*/ {
    if (isProcessingDeclSpec()) {
      return getMutableDeclSpec().getAttributes().getListRef();
    }
    return declarator.getTypeObject(chunkIndex).getAttrListRef();
  }

  
  /// Save the current set of attributes on the DeclSpec.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::saveDeclSpecAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 199,
   FQN="(anonymous namespace)::TypeProcessingState::saveDeclSpecAttrs", NM="_ZN12_GLOBAL__N_119TypeProcessingState17saveDeclSpecAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingState17saveDeclSpecAttrsEv")
  //</editor-fold>
  public void saveDeclSpecAttrs() {
    // Don't try to save them multiple times.
    if (hasSavedAttrs) {
      return;
    }
    
    final DeclSpec /*&*/ spec = getMutableDeclSpec();
    for (AttributeList /*P*/ attr = spec.getAttributes().getList(); (attr != null);
         attr = attr.getNext())  {
      savedAttrs.push_back(attr);
    }
    trivial &= savedAttrs.empty();
    hasSavedAttrs = true;
  }

  
  /// Record that we had nowhere to put the given type attribute.
  /// We will diagnose such attributes later.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::addIgnoredTypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 213,
   FQN="(anonymous namespace)::TypeProcessingState::addIgnoredTypeAttr", NM="_ZN12_GLOBAL__N_119TypeProcessingState18addIgnoredTypeAttrERN5clang13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingState18addIgnoredTypeAttrERN5clang13AttributeListE")
  //</editor-fold>
  public void addIgnoredTypeAttr(final AttributeList /*&*/ attr) {
    ignoredTypeAttrs.push_back($AddrOf(attr));
  }

  
  /// Diagnose all the ignored type attributes, given that the
  /// declarator worked out to the given type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::diagnoseIgnoredTypeAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 219,
   FQN="(anonymous namespace)::TypeProcessingState::diagnoseIgnoredTypeAttrs", NM="_ZNK12_GLOBAL__N_119TypeProcessingState24diagnoseIgnoredTypeAttrsEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState24diagnoseIgnoredTypeAttrsEN5clang8QualTypeE")
  //</editor-fold>
  public void diagnoseIgnoredTypeAttrs(QualType type) /*const*/ {
    for (AttributeList /*P*/ Attr : ignoredTypeAttrs)  {
      diagnoseBadTypeAttribute(getSema(), $Deref(Attr), new QualType(type));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::~TypeProcessingState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 224,
   FQN="(anonymous namespace)::TypeProcessingState::~TypeProcessingState", NM="_ZN12_GLOBAL__N_119TypeProcessingStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingStateD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (trivial) {
      return;
    }
    
    restoreDeclSpecAttrs();
    //START JDestroy
    ignoredTypeAttrs.$destroy();
    savedAttrs.$destroy();
    //END JDestroy
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::getMutableDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 231,
   FQN="(anonymous namespace)::TypeProcessingState::getMutableDeclSpec", NM="_ZNK12_GLOBAL__N_119TypeProcessingState18getMutableDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK12_GLOBAL__N_119TypeProcessingState18getMutableDeclSpecEv")
  //</editor-fold>
  private DeclSpec /*&*/ getMutableDeclSpec() /*const*/ {
    return ((/*const_cast*/DeclSpec /*&*/ )(declarator.getDeclSpec()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeProcessingState::restoreDeclSpecAttrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 235,
   FQN="(anonymous namespace)::TypeProcessingState::restoreDeclSpecAttrs", NM="_ZN12_GLOBAL__N_119TypeProcessingState20restoreDeclSpecAttrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN12_GLOBAL__N_119TypeProcessingState20restoreDeclSpecAttrsEv")
  //</editor-fold>
  private void restoreDeclSpecAttrs() {
    assert (hasSavedAttrs);
    if (savedAttrs.empty()) {
      getMutableDeclSpec().getAttributes().set((AttributeList /*P*/ )null);
      return;
    }
    
    getMutableDeclSpec().getAttributes().set(savedAttrs.$at(0));
    for (/*uint*/int i = 0, e = savedAttrs.size() - 1; i != e; ++i)  {
      savedAttrs.$at(i).setNext(savedAttrs.$at(i + 1));
    }
    savedAttrs.back().setNext((AttributeList /*P*/ )null);
  }

  
  @Override public String toString() {
    return "" + "sema=" + "[Sema]" // NOI18N
              + ", declarator=" + declarator // NOI18N
              + ", chunkIndex=" + chunkIndex // NOI18N
              + ", trivial=" + trivial // NOI18N
              + ", hasSavedAttrs=" + hasSavedAttrs // NOI18N
              + ", savedAttrs=" + savedAttrs // NOI18N
              + ", ignoredTypeAttrs=" + ignoredTypeAttrs; // NOI18N
  }
}
