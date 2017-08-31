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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.serialization.reader.impl.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import org.llvm.adt.*;
import org.llvm.support.*;

/// \brief Visitor class used to look up identifirs in an AST file.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierLookupVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1703,
 FQN="(anonymous namespace)::IdentifierLookupVisitor", NM="_ZN12_GLOBAL__N_123IdentifierLookupVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_123IdentifierLookupVisitorE")
//</editor-fold>
public class IdentifierLookupVisitor implements ModuleFile$Ref2Bool {
  private final/*private*/ StringRef Name;
  private final/*private*/ /*uint*/int NameHash;
  private final/*private*/ /*uint*/int PriorGeneration;
  private final uint$ref/*uint &*/ NumIdentifierLookups;
  private final uint$ref/*uint &*/ NumIdentifierLookupHits;
  private IdentifierInfo /*P*/ Found;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierLookupVisitor::IdentifierLookupVisitor">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1712,
   FQN="(anonymous namespace)::IdentifierLookupVisitor::IdentifierLookupVisitor", NM="_ZN12_GLOBAL__N_123IdentifierLookupVisitorC1EN4llvm9StringRefEjRjS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_123IdentifierLookupVisitorC1EN4llvm9StringRefEjRjS3_")
  //</editor-fold>
  public IdentifierLookupVisitor(StringRef Name, /*uint*/int PriorGeneration, 
      final uint$ref/*uint &*/ NumIdentifierLookups, 
      final uint$ref/*uint &*/ NumIdentifierLookupHits) {
    // : Name(Name), NameHash(ASTIdentifierLookupTrait::ComputeHash(Name)), PriorGeneration(PriorGeneration), NumIdentifierLookups(NumIdentifierLookups), NumIdentifierLookupHits(NumIdentifierLookupHits), Found(implicit IdentifierInfo * ()) 
    //START JInit
    this.Name = new StringRef(Name);
    this.NameHash = ASTIdentifierLookupTrait.$ComputeHash(Name);
    this.PriorGeneration = PriorGeneration;
    this./*&*/NumIdentifierLookups=/*&*/NumIdentifierLookups;
    this./*&*/NumIdentifierLookupHits=/*&*/NumIdentifierLookupHits;
    this.Found = /*implicit-init*/((IdentifierInfo /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierLookupVisitor::operator()">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1723,
   FQN="(anonymous namespace)::IdentifierLookupVisitor::operator()", NM="_ZN12_GLOBAL__N_123IdentifierLookupVisitorclERN5clang13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_123IdentifierLookupVisitorclERN5clang13serialization10ModuleFileE")
  //</editor-fold>
  @Override public final/*public*/ boolean $call(final ModuleFile /*&*/ M) {
    // If we've already searched this module file, skip it now.
    if ($lesseq_uint(M.Generation, PriorGeneration)) {
      return true;
    }
    
    OnDiskIterableChainedHashTable/*<ASTIdentifierLookupTrait>*/ /*P*/ IdTable = (OnDiskIterableChainedHashTable/*<ASTIdentifierLookupTrait>*/ /*P*/ )M.IdentifierLookupTable;
    if (!(IdTable != null)) {
      return false;
    }
    
    ASTIdentifierLookupTrait Trait/*J*/= new ASTIdentifierLookupTrait(((ASTIdentifierLookupTrait)IdTable.getInfoObj()).getReader(), M, 
        Found);
    NumIdentifierLookups.$set$preInc();
    OnDiskIterableChainedHashTable.iterator/*<ASTIdentifierLookupTrait>*/<?,?,IdentifierInfo /*P*/> Pos = IdTable.find_hashed(Name, NameHash, $AddrOf(Trait));
    if (Pos.$eq(IdTable.end())) {
      return false;
    }
    
    // Dereferencing the iterator has the effect of building the
    // IdentifierInfo node and populating it with the various
    // declarations it needs.
    NumIdentifierLookupHits.$set$preInc();
    Found = Pos.$star();
    return true;
  }

  
  // \brief Retrieve the identifier info found within the module
  // files.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IdentifierLookupVisitor::getIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1751,
   FQN="(anonymous namespace)::IdentifierLookupVisitor::getIdentifierInfo", NM="_ZNK12_GLOBAL__N_123IdentifierLookupVisitor17getIdentifierInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_123IdentifierLookupVisitor17getIdentifierInfoEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifierInfo() /*const*/ {
    return Found;
  }

  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", NameHash=" + NameHash // NOI18N
              + ", PriorGeneration=" + PriorGeneration // NOI18N
              + ", NumIdentifierLookups=" + NumIdentifierLookups // NOI18N
              + ", NumIdentifierLookupHits=" + NumIdentifierLookupHits // NOI18N
              + ", Found=" + Found; // NOI18N
  }
}
