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

package org.clang.basic.llvm.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 170,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 331,
 FQN = "llvm::DenseMapInfo<llvm::StringRef>", NM = "_ZN4llvm12DenseMapInfoINS_9StringRefEEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm12DenseMapInfoINS_9StringRefEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoStringRef implements DenseMapInfo<StringRef> {
  private static final StringRef emptyKey = new StringRef();
  private static final StringRef tombstoneKey = new StringRef();
  // This assumes that "" will never be a valid key.
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<llvm::StringRef>::getEmptyKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 334,
   FQN = "llvm::DenseMapInfo<llvm::StringRef>::getEmptyKey", NM = "_ZN4llvm12DenseMapInfoINS_9StringRefEE11getEmptyKeyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm12DenseMapInfoINS_9StringRefEE11getEmptyKeyEv")
  //</editor-fold>
  @Override
  public /*inline*/ StringRef getEmptyKey() {
    return emptyKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<llvm::StringRef>::getTombstoneKey">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 335,
   FQN = "llvm::DenseMapInfo<llvm::StringRef>::getTombstoneKey", NM = "_ZN4llvm12DenseMapInfoINS_9StringRefEE15getTombstoneKeyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm12DenseMapInfoINS_9StringRefEE15getTombstoneKeyEv")
  //</editor-fold>
  @Override
  public /*inline*/ StringRef getTombstoneKey() {
    return tombstoneKey;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<llvm::StringRef>::getHashValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 336,
   FQN = "llvm::DenseMapInfo<llvm::StringRef>::getHashValue", NM = "_ZN4llvm12DenseMapInfoINS_9StringRefEE12getHashValueES1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm12DenseMapInfoINS_9StringRefEE12getHashValueES1_")
  //</editor-fold>
  @Override
  public /*uint*/int getHashValue(StringRef Val) {
    assert Val != emptyKey : "must not be called for emptyKey";
    assert Val != tombstoneKey : "must not be called for tombstoneKey";    
    return HashString((StringRef)Val);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<llvm::StringRef>::isEqual">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 337,
   FQN = "llvm::DenseMapInfo<llvm::StringRef>::isEqual", NM = "_ZN4llvm12DenseMapInfoINS_9StringRefEE7isEqualES1_S1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN4llvm12DenseMapInfoINS_9StringRefEE7isEqualES1_S1_")
  //</editor-fold>
  @Override
  public boolean isEqual(StringRef LHS, StringRef RHS) {
    assert LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";      
    return $eq_StringRef((StringRef)LHS, (StringRef)RHS);
  }

  public String toString() {
    return ""; // NOI18N
  }

  @Override
  public boolean isKeyPointerLike() {
    return false;
  }
  
  private static final DenseMapInfoStringRef Info = new DenseMapInfoStringRef();
  public static final DenseMapInfoStringRef $Info() {
    return Info;
  }
}

