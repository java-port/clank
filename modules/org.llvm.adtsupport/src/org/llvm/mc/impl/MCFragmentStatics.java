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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.mc.*;


//<editor-fold defaultstate="collapsed" desc="static type MCFragmentStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCFragmentStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZL14getLabelOffsetRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy;_ZL19getSymbolOffsetImplRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy; -static-type=MCFragmentStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCFragmentStatics {


// Simple getSymbolOffset helper for the non-varibale case.
//<editor-fold defaultstate="collapsed" desc="getLabelOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 84,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 85,
 FQN="getLabelOffset", NM="_ZL14getLabelOffsetRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZL14getLabelOffsetRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy")
//</editor-fold>
public static boolean getLabelOffset(final /*const*/ MCAsmLayout /*&*/ Layout, final /*const*/ MCSymbol /*&*/ S, 
              boolean ReportError, final ulong$ref/*uint64_t &*/ Val) {
  if (!(S.getFragment() != null)) {
    if (ReportError) {
      report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"unable to evaluate offset to undefined symbol '", 
                  S.getName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
    }
    return false;
  }
  Val.$set(Layout.getFragmentOffset(S.getFragment()) + S.getOffset());
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getSymbolOffsetImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 96,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 97,
 FQN="getSymbolOffsetImpl", NM="_ZL19getSymbolOffsetImplRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZL19getSymbolOffsetImplRKN4llvm11MCAsmLayoutERKNS_8MCSymbolEbRy")
//</editor-fold>
public static boolean getSymbolOffsetImpl(final /*const*/ MCAsmLayout /*&*/ Layout, final /*const*/ MCSymbol /*&*/ S, 
                   boolean ReportError, final ulong$ref/*uint64_t &*/ Val) {
  if (!S.isVariable()) {
    return getLabelOffset(Layout, S, ReportError, Val);
  }
  
  // If SD is a variable, evaluate it.
  MCValue Target/*J*/= new MCValue();
  if (!S.getVariableValue().evaluateAsValue(Target, Layout)) {
    report_fatal_error($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"unable to evaluate offset for variable '", 
                S.getName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
  }
  
  long/*uint64_t*/ Offset = Target.getConstant();
  
  /*const*/ MCSymbolRefExpr /*P*/ A = Target.getSymA();
  if ((A != null)) {
    ulong$ref ValA = create_ulong$ref();
    if (!getLabelOffset(Layout, A.getSymbol(), ReportError, ValA)) {
      return false;
    }
    Offset += ValA.$deref();
  }
  
  /*const*/ MCSymbolRefExpr /*P*/ B = Target.getSymB();
  if ((B != null)) {
    ulong$ref ValB = create_ulong$ref();
    if (!getLabelOffset(Layout, B.getSymbol(), ReportError, ValB)) {
      return false;
    }
    Offset -= ValB.$deref();
  }
  
  Val.$set(Offset);
  return true;
}

} // END OF class MCFragmentStatics
