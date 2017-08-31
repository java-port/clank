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

package org.llvm.adt;

import org.clank.support.*;
import org.llvm.adt.*;


/// DefaultFoldingSetTrait - This class provides default implementations
/// for FoldingSetTrait implementations.
///
/// JAVA: Inheritance chain is inverted in Java! FoldingSetTrait made as an interface and
/// DefaultFoldingSetTrait implements it!
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DefaultFoldingSetTrait">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 209,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 210,
 FQN="llvm::DefaultFoldingSetTrait", NM="_ZN4llvm22DefaultFoldingSetTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22DefaultFoldingSetTraitE")
//</editor-fold>
public class/*struct*/ DefaultFoldingSetTrait</*typename*/ T extends FoldingSetTrait.Profilable> implements FoldingSetTrait<T> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultFoldingSetTrait::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 211,
   FQN="llvm::DefaultFoldingSetTrait::Profile", NM="_ZN4llvm22DefaultFoldingSetTrait7ProfileERKT_RNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22DefaultFoldingSetTrait7ProfileERKT_RNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(/*const*/ T /*&*/ X, FoldingSetNodeID /*&*/ ID) {
    X.Profile(ID);
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultFoldingSetTrait::Profile">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 213,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 214,
//   FQN="llvm::DefaultFoldingSetTrait::Profile", NM="_ZN4llvm22DefaultFoldingSetTrait7ProfileERT_RNS_16FoldingSetNodeIDE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22DefaultFoldingSetTrait7ProfileERT_RNS_16FoldingSetNodeIDE")
//  //</editor-fold>
//  public void Profile(T /*&*/ X, FoldingSetNodeID /*&*/ ID) {
//    X.Profile(ID);
//  }

  
  // Equals - Test if the profile for X would match ID, using TempID
  // to compute a temporary ID if necessary. The default implementation
  // just calls Profile and does a regular comparison. Implementations
  // can override this to provide more efficient implementations.
  
  // Definitions of FoldingSetTrait and ContextualFoldingSetTrait functions, which
  // require the definition of FoldingSetNodeID.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultFoldingSetTrait::Equals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 357,
   FQN="llvm::DefaultFoldingSetTrait::Equals", NM="_ZN4llvm22DefaultFoldingSetTrait6EqualsERT_RKNS_16FoldingSetNodeIDEjRS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22DefaultFoldingSetTrait6EqualsERT_RKNS_16FoldingSetNodeIDEjRS3_")
  //</editor-fold>
  public /*inline*/ boolean Equals(T /*&*/ X, /*const*/ FoldingSetNodeID /*&*/ ID, 
        /*uint*/int $Prm2/*IDHash*/, 
        FoldingSetNodeID /*&*/ TempID) {
    Profile(X, TempID);
    return TempID.$eq(ID);
  }

  
  // ComputeHash - Compute a hash value for X, using TempID to
  // compute a temporary ID if necessary. The default implementation
  // just calls Profile and does a regular hash computation.
  // Implementations can override this to provide more efficient
  // implementations.
  //<editor-fold defaultstate="collapsed" desc="llvm::DefaultFoldingSetTrait::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 365,
   FQN="llvm::DefaultFoldingSetTrait::ComputeHash", NM="_ZN4llvm22DefaultFoldingSetTrait11ComputeHashERT_RNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22DefaultFoldingSetTrait11ComputeHashERT_RNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public /*inline*/ /*uint*/int ComputeHash(T /*&*/ X, FoldingSetNodeID /*&*/ TempID) {
    Profile(X, TempID);
    return TempID.ComputeHash();
  }

  
  public String toString() {
    return ""; // NOI18N
  }
}
