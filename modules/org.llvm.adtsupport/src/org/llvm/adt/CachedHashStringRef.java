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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.Native.NativePOD;
import static org.llvm.adt.HashingGlobals.hash_value;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::CachedHash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 33,
 FQN="llvm::CachedHash", NM="_ZN4llvm10CachedHashE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm10CachedHashE")
//</editor-fold>
public class/*struct*/ CachedHashStringRef implements NativePOD<CachedHashStringRef>, NativeSwappable {
  //<editor-fold defaultstate="collapsed" desc="llvm::CachedHash<StringRef>::CachedHash">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 34,
   FQN="llvm::CachedHash<StringRef>::CachedHash", NM="_ZN4llvm10CachedHashINS_9StringRefEEC1ES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/StringTableBuilder.cpp -nm=_ZN4llvm10CachedHashINS_9StringRefEEC1ES1_")
  //</editor-fold>
  public CachedHashStringRef(StringRef Val) {
    // : Val(std::move(Val)) 
    //START JInit
    this.Val = new StringRef(JD$Move.INSTANCE, std.move(Val));
    //END JInit
    Hash = hash_value(Val).$uint();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CachedHash<StringRef>::CachedHash">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 37,
   FQN="llvm::CachedHash<StringRef>::CachedHash", NM="_ZN4llvm10CachedHashINS_9StringRefEEC1ES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/ELFObjectWriter.cpp -nm=_ZN4llvm10CachedHashINS_9StringRefEEC1ES1_j")
  //</editor-fold>
  public CachedHashStringRef(StringRef Val, /*uint*/int Hash) {
    // : Val(std::move(Val)), Hash(Hash) 
    //START JInit
    this.Val = new StringRef(JD$Move.INSTANCE, std.move(Val));
    this.Hash = Hash;
    //END JInit
  }

  public StringRef Val;
  public /*uint*/int Hash;
  
  private CachedHashStringRef() {
  }

  public static CachedHashStringRef getEmptyKey(){
    CachedHashStringRef res = new CachedHashStringRef();
    res.Val = new StringRef();//reinterpret_cast<const char *>(~static_cast<uintptr_t>(0)), 0);
    res.Hash = 0;
    return res;
  }
  
  public static CachedHashStringRef getTombstoneKey(){
    CachedHashStringRef res = new CachedHashStringRef();
    res.Val = new StringRef();//reinterpret_cast<const char *>(~static_cast<uintptr_t>(1)), 0);
    res.Hash = 0;
    return res;
  }

  @Override public String toString() {
    return "" + "Val=" + Val // NOI18N
              + ", Hash=" + Hash; // NOI18N
  }

  @Override
  public CachedHashStringRef $assign(CachedHashStringRef $Prm0) {
    this.Val.$assign($Prm0.Val);
    this.Hash = $Prm0.Hash;
    return this;
  }

  public CachedHashStringRef(CachedHashStringRef $Prm0) {
    //START JInit
    this.Val = new StringRef($Prm0.Val);
    this.Hash = $Prm0.Hash;
    //END JInit
  }
  
  @Override
  public CachedHashStringRef clone() {
    return new CachedHashStringRef(this);
  }

  @Override
  public void swap(NativeSwappable $Prm0) {
    CachedHashStringRef RHS = (CachedHashStringRef) $Prm0;
    this.Val.swap(RHS.Val);
    int Tmp = this.Hash;
    this.Hash = RHS.Hash;
    RHS.Hash = Tmp;
  }
}
