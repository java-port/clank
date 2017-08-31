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

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;


/// StringMapEntryBase - Shared base class of StringMapEntry instances.
//<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryBase">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 31,
 FQN = "llvm::StringMapEntryBase", NM = "_ZN4llvm18StringMapEntryBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZN4llvm18StringMapEntryBaseE")
//</editor-fold>
public abstract class StringMapEntryBase {
//  private final /*uint*/int StrLen;
  /*friend*/ final int FullHashCode;

  public final int $HashCode() {
    return FullHashCode;
  }
  
  protected static char$ptr createDummyCharPtr(/*uint*/int Len) {
    byte[] new$char = new$char(Len + 1);
    for (int i = 0; i < (int)Len; i++) {
      new$char[i] = 0xD;
    }
    new$char[(int)Len] = 0x0;
    return NativePointer.create_const_char$ptr(new$char);
  }
  
/*public:*/
  public /*explicit*/ StringMapEntryBase(char$ptr Str, /*uint*/int Len) {
    /* : StrLen(Len)*/ 
    //START JInit
//    this.StrLen = $long2uint(Len);
    //END JInit
    this.FullHashCode = HashString(Str, Len);
  }
  public /*explicit*/ StringMapEntryBase(byte Str[], int fromIdx, /*uint*/int Len) {
    /* : StrLen(Len)*/ 
    //START JInit
//    this.StrLen = $long2uint(Len);
    //END JInit
    this.FullHashCode = HashString(Str, fromIdx, Len);
  }
  public /*explicit*/ StringMapEntryBase(byte Str[], int fromIdx, /*uint*/int Len, int FullHashValue) {
    /* : StrLen(Len)*/ 
    //START JInit
//    this.StrLen = $long2uint(Len);
    //END JInit
    this.FullHashCode = FullHashValue;
    assert HashString(Str, fromIdx, Len) == FullHashValue;
  }
  
  public /*explicit*/ StringMapEntryBase(StringMapEntryBase other) {
    /* : StrLen(Len)*/ 
    //START JInit
//    this.StrLen = other.StrLen;
    //END JInit
    this.FullHashCode = other.FullHashCode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryBase::getKeyLength">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", old_line = 36,
   FQN = "llvm::StringMapEntryBase::getKeyLength", NM = "_ZNK4llvm18StringMapEntryBase12getKeyLengthEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -nm=_ZNK4llvm18StringMapEntryBase12getKeyLengthEv")
  //</editor-fold>
  public abstract /*uint*/int getKeyLength() /*const*/;
  
  public abstract char$ptr getKeyStr();
  
  public abstract byte[] getKeyArray();
  
  public abstract int getKeyArrayIndex();
    
  protected static int $sizeof_StringMapEntryBase_Fields() {
    return NativeType.BYTES_IN_UINT + NativeType.BYTES_IN_JAVA_OBJECT_REF;
  }

  // JAVA: allow to reset entries for reuse
  protected void resetStringMapEntryToInitialState() {
    // in derived class override and reset to initial state (as created by entry allocatros)
  }

  public int compareKey(StringMapEntryBase RHS) {
    if (RHS == this) {
        return 0;
    }
    int LHSLen = this.getKeyLength();
    int RHSLen = RHS.getKeyLength();
    {
      // Check the prefix for a mismatch.
      int Res = std.memcmp(getKeyArray(), getKeyArrayIndex(), RHS.getKeyArray(), RHS.getKeyArrayIndex(), std.min(LHSLen, RHSLen));
      if ((Res != 0)) {
        return Res < 0 ? -1 : 1;
      }
    }
    
    // Otherwise the prefixes match, so we only need to check the lengths.
    if (LHSLen == RHSLen) {
      return 0;
    }
    return LHSLen < RHSLen ? -1 : 1;    
  }
}
