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

package org.llvm.adt.aliases;

import org.clank.support.Converted;
import org.llvm.adt.DenseMapInfo;
import org.clank.support.*;

/**
 * class used to manage keys in Set/Map collections.
 * DenseMapInfo<TypePtr *> where TypePtr is C++ pointer but not void$ptr (@see DenseMapInfoVoid$Ptr),
 * and not NativeHashable class-pointers (@see DenseMapInfoHashable$LikePtr).
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PTHStringLookupTrait">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 23,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -filter=llvm::DenseMapInfo")
//</editor-fold>
public class DenseMapInfo$LikePtr<TyPtr/*P*/> implements DenseMapInfo<TyPtr/*P*/>{
  private static final DenseMapInfo$LikePtr $INFO = new DenseMapInfo$LikePtr();
  
  private final boolean allowCompareWithEmptyAndTombstone;
  protected final Object/*P*/ emptyKey;
  protected final Object/*P*/ tombstoneKey;
  
  public static <TyPtr/*P*/> DenseMapInfo$LikePtr<TyPtr/*P*/> $Info() {
    return $INFO;
  }

  public DenseMapInfo$LikePtr() {
    this(new Object/*P*/(), new Object/*P*/());
  }
  public DenseMapInfo$LikePtr(Object/*P*/ emptyKey, Object/*P*/ tombstoneKey) {
    this(emptyKey, tombstoneKey, false);
  }
  public DenseMapInfo$LikePtr(Object/*P*/ emptyKey, Object/*P*/ tombstoneKey, boolean allowCompareWithEmptyAndTombstone) {
    this.emptyKey = emptyKey;
    this.tombstoneKey = tombstoneKey;
    this.allowCompareWithEmptyAndTombstone = allowCompareWithEmptyAndTombstone;
    assert this.tombstoneKey != this.emptyKey : "emptyKey [" + this.emptyKey + "] must be different from tombstoneKey [" + this.tombstoneKey + "]";
    assert (emptyKey != null) : "emptyKey marker must be non null";
    assert (tombstoneKey != null) : "tombstoneKey marker must be non null";
  }

  public final/*inline*/ Object/*P*/ getEmptyKey() {
    return emptyKey;
  }

  public final/*inline*/ Object/*P*/ getTombstoneKey() {
    return tombstoneKey;
  }

  /**
   * @return return hashcode for the key (it is neither empty nor tombstone keys)
   */  
  public /*uint*/int getHashValue(/*const*/TyPtr/*P*/ Key) {
    assert allowCompareWithEmptyAndTombstone || Key != emptyKey : "Key: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || Key != tombstoneKey : "Key: must not be called for tombstoneKey";
    assert checkKey(Key);
    return System.identityHashCode(Key);
  }

  /**
   * IMPORTANT: hashcode value for AltKey must match hash-value for the original key.
   * @return return hashcode for the alternative key types (it is neither empty nor tombstone keys)
   */ 
  public /*uint*/int getHashValueAlt(/*const*/Object/*&*/ AltKey) {
    assert AltKey != emptyKey : "AltKey: must not be called for emptyKey";
    assert AltKey != tombstoneKey : "AltKey: must not be called for tombstoneKey";
    
    throw new UnsupportedOperationException("Override to support alternative Key types with hash same as Key");    
  }

  /**
   * @return true when LHS key is equal to the RHS key (LHS/RHS are neither empty nor tombstone keys)
   */  
  public boolean isEqual(/*const*/TyPtr/*P*/ LHS, /*const*/TyPtr/*P*/ RHS) {
    assert allowCompareWithEmptyAndTombstone || LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert allowCompareWithEmptyAndTombstone || RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
    assert checkKey(LHS);
    assert checkKey(RHS);
    return LHS == RHS; // java-class pointers are equal when java-references are equal
  }

  /**
   * @return true when alternative LHS key is equal to the stored RHS key (LHS/RHS is neither empty nor tombstone keys)
   */  
  public boolean isEqualAlt(/*const*/ Object /*&*/ AltKey, /*const*/ TyPtr/*P*/ /*&*/ Key) {
    assert AltKey != emptyKey : "AltKey: must not be called for emptyKey";
    assert AltKey != tombstoneKey : "AltKey: must not be called for tombstoneKey";
    assert allowCompareWithEmptyAndTombstone || Key != emptyKey : "Key: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || Key != tombstoneKey : "Key: must not be called for tombstoneKey";
    assert checkKey(Key);
    
    throw new UnsupportedOperationException("Override to support alternative Key types comparable with Key");
  }
  
  public boolean isKeyPointerLike() {
    // never copy pointers
    return true;
  }  

  protected boolean checkKey(Object Key) { return checkKeyImpl(Key, false); }
  protected boolean checkAltKey(Object AltKey) { return checkKeyImpl(AltKey, true); }

  protected boolean checkKeyImpl(Object Key, boolean altKey) {
    if (!NativeTrace.isDebugMode()) {
      NativeTrace.printStackTraceOnce(new Exception("must be called inside assert"));
      return true;
    }
    if (Key == null) return true;
    if (Key instanceof void$ptr) {
      throw new IllegalArgumentException("for void$ptr [" + Key.getClass() + "] classes use DenseMapInfoVoid$Ptr");
    }
    // some objects are better to be asked for hash code without System.identityHashCode
    if (Key instanceof Native.NativeHashable) {
      NativeTrace.printStackTraceOnce(new Exception("use DenseMapInfoHashable$LikePtr instead"));
    }
    return true;
  }
}
