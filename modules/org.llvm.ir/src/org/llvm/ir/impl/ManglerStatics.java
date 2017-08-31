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
package org.llvm.ir.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ManglerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ManglerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZL18addByteCountSuffixRN4llvm11raw_ostreamEPKNS_8FunctionERKNS_10DataLayoutE;_ZL18hasByteCountSuffixj;_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineEN12_GLOBAL__N_115ManglerPrefixTyERKNS_10DataLayoutEc;_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineERKNS_10DataLayoutEN12_GLOBAL__N_115ManglerPrefixTyE; -static-type=ManglerStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class ManglerStatics {

//<editor-fold defaultstate="collapsed" desc="getNameWithPrefixImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 32,
 FQN="getNameWithPrefixImpl", NM="_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineEN12_GLOBAL__N_115ManglerPrefixTyERKNS_10DataLayoutEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineEN12_GLOBAL__N_115ManglerPrefixTyERKNS_10DataLayoutEc")
//</editor-fold>
public static void getNameWithPrefixImpl(final raw_ostream /*&*/ OS, final /*const*/ Twine /*&*/ GVName, 
                     ManglerPrefixTy PrefixTy, 
                     final /*const*/ DataLayout /*&*/ DL, /*char*/byte Prefix) {
  SmallString/*<256>*/ TmpData/*J*/= new SmallString/*<256>*/(256);
  StringRef Name = GVName.toStringRef(TmpData);
  assert (!Name.empty()) : "getNameWithPrefix requires non-empty name";
  
  // No need to do anything special if the global has the special "do not
  // mangle" flag in the name.
  if (Name.$at(0) == $$SOH) {
    OS.$out(Name.substr(1));
    return;
  }
  if (PrefixTy == ManglerPrefixTy.Private) {
    OS.$out(DL.getPrivateGlobalPrefix());
  } else if (PrefixTy == ManglerPrefixTy.LinkerPrivate) {
    OS.$out(DL.getLinkerPrivateGlobalPrefix());
  }
  if (Prefix != $$TERM) {
    OS.$out_char(Prefix);
  }
  
  // If this is a simple string that doesn't need escaping, just append it.
  OS.$out(/*NO_COPY*/Name);
}

//<editor-fold defaultstate="collapsed" desc="getNameWithPrefixImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 58,
 FQN="getNameWithPrefixImpl", NM="_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineERKNS_10DataLayoutEN12_GLOBAL__N_115ManglerPrefixTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZL21getNameWithPrefixImplRN4llvm11raw_ostreamERKNS_5TwineERKNS_10DataLayoutEN12_GLOBAL__N_115ManglerPrefixTyE")
//</editor-fold>
public static void getNameWithPrefixImpl(final raw_ostream /*&*/ OS, final /*const*/ Twine /*&*/ GVName, 
                     final /*const*/ DataLayout /*&*/ DL, 
                     ManglerPrefixTy PrefixTy) {
  /*char*/byte Prefix = DL.getGlobalPrefix();
  getNameWithPrefixImpl(OS, GVName, PrefixTy, DL, Prefix);
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="hasByteCountSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 77,
 FQN="hasByteCountSuffix", NM="_ZL18hasByteCountSuffixj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZL18hasByteCountSuffixj")
//</editor-fold>
public static boolean hasByteCountSuffix(/*uint*/int CC) {
  switch (CC) {
   case CallingConv.X86_FastCall:
   case CallingConv.X86_StdCall:
   case CallingConv.X86_VectorCall:
    return true;
   default:
    return false;
  }
}


/// Microsoft fastcall and stdcall functions require a suffix on their name
/// indicating the number of words of arguments they take.
//<editor-fold defaultstate="collapsed" desc="addByteCountSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Mangler.cpp", line = 90,
 FQN="addByteCountSuffix", NM="_ZL18addByteCountSuffixRN4llvm11raw_ostreamEPKNS_8FunctionERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Mangler.cpp -nm=_ZL18addByteCountSuffixRN4llvm11raw_ostreamEPKNS_8FunctionERKNS_10DataLayoutE")
//</editor-fold>
public static void addByteCountSuffix(final raw_ostream /*&*/ OS, /*const*/ Function /*P*/ F, 
                  final /*const*/ DataLayout /*&*/ DL) {
  // Calculate arguments size total.
  /*uint*/int ArgWords = 0;
  for (ilist_iterator</*const*/ Argument> AI = F.arg_begin$Const(), AE = F.arg_end$Const();
       AI.$noteq(AE); AI.$preInc()) {
    Type /*P*/ Ty = AI.$arrow().getType();
    // 'Dereference' type in case of byval or inalloca parameter attribute.
    if (AI.$arrow().hasByValOrInAllocaAttr()) {
      Ty = cast_PointerType(Ty).getElementType();
    }
    // Size should be aligned to pointer size.
    /*uint*/int PtrSize = DL.getPointerSize();
    ArgWords += alignTo(DL.getTypeAllocSize(Ty), $uint2ulong(PtrSize));
  }
  
  OS.$out_char($$AT).$out_uint(ArgWords);
}

} // END OF class ManglerStatics
