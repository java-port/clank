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
package org.llvm.mc.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.mc.*;


//<editor-fold defaultstate="collapsed" desc="static type MCCodeViewStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCCodeViewStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZL16computeLabelDiffRN4llvm11MCAsmLayoutEPKNS_8MCSymbolES4_;_ZL18compressAnnotationN4llvm8codeview23BinaryAnnotationsOpCodeERNS_15SmallVectorImplIcEE;_ZL18compressAnnotationjRN4llvm15SmallVectorImplIcEE;_ZL18encodeSignedNumberj; -static-type=MCCodeViewStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCCodeViewStatics {

//<editor-fold defaultstate="collapsed" desc="compressAnnotation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 206,
 FQN="compressAnnotation", NM="_ZL18compressAnnotationjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZL18compressAnnotationjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static boolean compressAnnotation(/*uint32_t*/int Data, final SmallString/*&*/ Buffer) {
  if (AdtsupportLlvmGlobals.isUInt(7, $uint2ulong(Data))) {
    Buffer.push_back($uint2char(Data));
    return true;
  }
  if (AdtsupportLlvmGlobals.isUInt(14, $uint2ulong(Data))) {
    Buffer.push_back($uint2char((Data >>> 8) | 0x80));
    Buffer.push_back($uint2char(Data & 0xff));
    return true;
  }
  if (AdtsupportLlvmGlobals.isUInt(29, $uint2ulong(Data))) {
    Buffer.push_back($uint2char((Data >>> 24) | 0xC0));
    Buffer.push_back($uint2char((Data >>> 16) & 0xff));
    Buffer.push_back($uint2char((Data >>> 8) & 0xff));
    Buffer.push_back($uint2char(Data & 0xff));
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="compressAnnotation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 229,
 FQN="compressAnnotation", NM="_ZL18compressAnnotationN4llvm8codeview23BinaryAnnotationsOpCodeERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZL18compressAnnotationN4llvm8codeview23BinaryAnnotationsOpCodeERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static boolean compressAnnotation(Native.NativeUIntEnum Annotation, 
                  final SmallString/*&*/ Buffer) {
  return compressAnnotation(((/*static_cast*//*uint32_t*/int)Annotation.getValue()), Buffer);
}

//<editor-fold defaultstate="collapsed" desc="encodeSignedNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 234,
 FQN="encodeSignedNumber", NM="_ZL18encodeSignedNumberj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZL18encodeSignedNumberj")
//</editor-fold>
public static /*uint32_t*/int encodeSignedNumber(/*uint32_t*/int Data) {
  if (((Data >>> 31) != 0)) {
    return ((-Data) << 1) | 1;
  }
  return Data << 1;
}

//<editor-fold defaultstate="collapsed" desc="computeLabelDiff">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 261,
 FQN="computeLabelDiff", NM="_ZL16computeLabelDiffRN4llvm11MCAsmLayoutEPKNS_8MCSymbolES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZL16computeLabelDiffRN4llvm11MCAsmLayoutEPKNS_8MCSymbolES4_")
//</editor-fold>
public static /*uint*/int computeLabelDiff(final MCAsmLayout /*&*/ Layout, /*const*/ MCSymbol /*P*/ Begin, 
                /*const*/ MCSymbol /*P*/ End) {
  final MCContext /*&*/ Ctx = Layout.getAssembler().getContext();
  MCSymbolRefExpr.VariantKind Variant = MCSymbolRefExpr.VariantKind.VK_None;
  /*const*/ MCExpr /*P*/ BeginRef = MCSymbolRefExpr.create(Begin, Variant, Ctx);
  /*const*/ MCExpr /*P*/ EndRef = MCSymbolRefExpr.create(End, Variant, Ctx);
  /*const*/ MCExpr /*P*/ AddrDelta = MCBinaryExpr.create(MCBinaryExpr.Opcode.Sub, EndRef, BeginRef, Ctx);
  long$ref Result = create_long$ref();
  boolean Success = AddrDelta.evaluateKnownAbsolute(Result, Layout);
  assert (Success) : "failed to evaluate label difference as absolute";
  ///*J:(void)*/Success;
  assert (Result.$deref() >= 0) : "negative label difference requested";
  assert (Result.$deref() < $uint2llong((2147483647 * 2/*U*/ + 1/*U*/))) : "label difference greater than 2GB";
  return ((/*uint*/int)($long2uint(Result.$deref())));
}

} // END OF class MCCodeViewStatics
