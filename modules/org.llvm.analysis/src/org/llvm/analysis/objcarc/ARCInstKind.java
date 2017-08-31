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

package org.llvm.analysis.objcarc;

import org.clank.support.*;


/// \enum ARCInstKind
///
/// \brief Equivalence classes of instructions in the ARC Model.
///
/// Since we do not have "instructions" to represent ARC concepts in LLVM IR,
/// we instead operate on equivalence classes of instructions.
///
/// TODO: This should be split into two enums: a runtime entry point enum
/// (possibly united with the ARCRuntimeEntrypoint class) and an enum that deals
/// with effects of instructions in the ARC model (which would handle the notion
/// of a User or CallOrUser).
//<editor-fold defaultstate="collapsed" desc="llvm::objcarc::ARCInstKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ObjCARCInstKind.h", line = 30,
 FQN="llvm::objcarc::ARCInstKind", NM="_ZN4llvm7objcarc11ARCInstKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCInstKind.cpp -nm=_ZN4llvm7objcarc11ARCInstKindE")
//</editor-fold>
public enum /*class */ARCInstKind/* : int*/ implements Native.NativeIntEnum {
  Retain(0), ///< objc_retain
  RetainRV(Retain.getValue() + 1), ///< objc_retainAutoreleasedReturnValue
  ClaimRV(RetainRV.getValue() + 1), ///< objc_unsafeClaimAutoreleasedReturnValue
  RetainBlock(ClaimRV.getValue() + 1), ///< objc_retainBlock
  Release(RetainBlock.getValue() + 1), ///< objc_release
  Autorelease(Release.getValue() + 1), ///< objc_autorelease
  AutoreleaseRV(Autorelease.getValue() + 1), ///< objc_autoreleaseReturnValue
  AutoreleasepoolPush(AutoreleaseRV.getValue() + 1), ///< objc_autoreleasePoolPush
  AutoreleasepoolPop(AutoreleasepoolPush.getValue() + 1), ///< objc_autoreleasePoolPop
  NoopCast(AutoreleasepoolPop.getValue() + 1), ///< objc_retainedObject, etc.
  FusedRetainAutorelease(NoopCast.getValue() + 1), ///< objc_retainAutorelease
  FusedRetainAutoreleaseRV(FusedRetainAutorelease.getValue() + 1), ///< objc_retainAutoreleaseReturnValue
  LoadWeakRetained(FusedRetainAutoreleaseRV.getValue() + 1), ///< objc_loadWeakRetained (primitive)
  StoreWeak(LoadWeakRetained.getValue() + 1), ///< objc_storeWeak (primitive)
  InitWeak(StoreWeak.getValue() + 1), ///< objc_initWeak (derived)
  LoadWeak(InitWeak.getValue() + 1), ///< objc_loadWeak (derived)
  MoveWeak(LoadWeak.getValue() + 1), ///< objc_moveWeak (derived)
  CopyWeak(MoveWeak.getValue() + 1), ///< objc_copyWeak (derived)
  DestroyWeak(CopyWeak.getValue() + 1), ///< objc_destroyWeak (derived)
  StoreStrong(DestroyWeak.getValue() + 1), ///< objc_storeStrong (derived)
  IntrinsicUser(StoreStrong.getValue() + 1), ///< clang.arc.use
  CallOrUser(IntrinsicUser.getValue() + 1), ///< could call objc_release and/or "use" pointers
  Call(CallOrUser.getValue() + 1), ///< could call objc_release
  User(Call.getValue() + 1), ///< could "use" a pointer
  None(User.getValue() + 1); ///< anything that is inert from an ARC perspective.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ARCInstKind valueOf(int val) {
    ARCInstKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ARCInstKind[] VALUES;
    private static final ARCInstKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ARCInstKind kind : ARCInstKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ARCInstKind[min < 0 ? (1-min) : 0];
      VALUES = new ARCInstKind[max >= 0 ? (1+max) : 0];
      for (ARCInstKind kind : ARCInstKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final int value;
  private ARCInstKind(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  //</editor-fold>
}
