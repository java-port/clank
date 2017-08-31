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
package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;;


//<editor-fold defaultstate="collapsed" desc="static type CodeviewGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.debuginfo.codeview.CodeviewGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview13consumeObjectERT0_RPKT_;Tpl__ZN4llvm8codeview15serialize_arrayERNS_8ArrayRefIT_EET0_;Tpl__ZN4llvm8codeview17serialize_numericERT_;Tpl__ZN4llvm8codeview20serialize_array_tailERNS_8ArrayRefIT_EE;Tpl__ZN4llvm8codeview20serialize_array_tailERSt6vectorIT_SaIS2_EE;Tpl__ZN4llvm8codeview21serialize_conditionalERT_T0_;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEEOT_OT0_DpOT1_;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_20serialize_array_implIT_T0_EE;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_22serialize_numeric_implIT_EE;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_conditional_implIT_T0_EE;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_vector_tail_implIT_EE;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_28serialize_arrayref_tail_implIT_EE;Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERPT_;_ZN4llvm8codeview32serialize_null_term_string_arrayERSt6vectorINS_9StringRefESaIS2_EE;_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEE;_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_37serialize_null_term_string_array_implE;_ZN4llvm8codeviewE_SymbolRecord_h_Unnamed_enum;_ZN4llvm8codeviewaNERNS0_11ExportFlagsES1_;_ZN4llvm8codeviewaNERNS0_12ClassOptionsES1_;_ZN4llvm8codeviewaNERNS0_12ProcSymFlagsES1_;_ZN4llvm8codeviewaNERNS0_13LocalSymFlagsES1_;_ZN4llvm8codeviewaNERNS0_13MethodOptionsES1_;_ZN4llvm8codeviewaNERNS0_14PointerOptionsES1_;_ZN4llvm8codeviewaNERNS0_15FunctionOptionsES1_;_ZN4llvm8codeviewaNERNS0_15ModifierOptionsES1_;_ZN4llvm8codeviewaNERNS0_16CompileSym2FlagsES1_;_ZN4llvm8codeviewaNERNS0_16CompileSym3FlagsES1_;_ZN4llvm8codeviewaNERNS0_21FrameProcedureOptionsES1_;_ZN4llvm8codeviewanENS0_11ExportFlagsES1_;_ZN4llvm8codeviewanENS0_12ClassOptionsES1_;_ZN4llvm8codeviewanENS0_12ProcSymFlagsES1_;_ZN4llvm8codeviewanENS0_13LocalSymFlagsES1_;_ZN4llvm8codeviewanENS0_13MethodOptionsES1_;_ZN4llvm8codeviewanENS0_14PointerOptionsES1_;_ZN4llvm8codeviewanENS0_15FunctionOptionsES1_;_ZN4llvm8codeviewanENS0_15ModifierOptionsES1_;_ZN4llvm8codeviewanENS0_16CompileSym2FlagsES1_;_ZN4llvm8codeviewanENS0_16CompileSym3FlagsES1_;_ZN4llvm8codeviewanENS0_21FrameProcedureOptionsES1_;_ZN4llvm8codeviewcoENS0_11ExportFlagsE;_ZN4llvm8codeviewcoENS0_12ClassOptionsE;_ZN4llvm8codeviewcoENS0_12ProcSymFlagsE;_ZN4llvm8codeviewcoENS0_13LocalSymFlagsE;_ZN4llvm8codeviewcoENS0_13MethodOptionsE;_ZN4llvm8codeviewcoENS0_14PointerOptionsE;_ZN4llvm8codeviewcoENS0_15FunctionOptionsE;_ZN4llvm8codeviewcoENS0_15ModifierOptionsE;_ZN4llvm8codeviewcoENS0_16CompileSym2FlagsE;_ZN4llvm8codeviewcoENS0_16CompileSym3FlagsE;_ZN4llvm8codeviewcoENS0_21FrameProcedureOptionsE;_ZN4llvm8codeviewoRERNS0_11ExportFlagsES1_;_ZN4llvm8codeviewoRERNS0_12ClassOptionsES1_;_ZN4llvm8codeviewoRERNS0_12ProcSymFlagsES1_;_ZN4llvm8codeviewoRERNS0_13LocalSymFlagsES1_;_ZN4llvm8codeviewoRERNS0_13MethodOptionsES1_;_ZN4llvm8codeviewoRERNS0_14PointerOptionsES1_;_ZN4llvm8codeviewoRERNS0_15FunctionOptionsES1_;_ZN4llvm8codeviewoRERNS0_15ModifierOptionsES1_;_ZN4llvm8codeviewoRERNS0_16CompileSym2FlagsES1_;_ZN4llvm8codeviewoRERNS0_16CompileSym3FlagsES1_;_ZN4llvm8codeviewoRERNS0_21FrameProcedureOptionsES1_;_ZN4llvm8codevieworENS0_11ExportFlagsES1_;_ZN4llvm8codevieworENS0_12ClassOptionsES1_;_ZN4llvm8codevieworENS0_12ProcSymFlagsES1_;_ZN4llvm8codevieworENS0_13LocalSymFlagsES1_;_ZN4llvm8codevieworENS0_13MethodOptionsES1_;_ZN4llvm8codevieworENS0_14PointerOptionsES1_;_ZN4llvm8codevieworENS0_15FunctionOptionsES1_;_ZN4llvm8codevieworENS0_15ModifierOptionsES1_;_ZN4llvm8codevieworENS0_16CompileSym2FlagsES1_;_ZN4llvm8codevieworENS0_16CompileSym3FlagsES1_;_ZN4llvm8codevieworENS0_21FrameProcedureOptionsES1_; -static-type=CodeviewGlobals -package=org.llvm.debuginfo.codeview")
//</editor-fold>
public final class CodeviewGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 207,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_12ClassOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_12ClassOptionsES1_")
//</editor-fold>
public static /*inline*/ /*ClassOptions*//*uint16_t*/char $bitor_ClassOptions(/*ClassOptions*//*uint16_t*/char a, /*ClassOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 207,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_12ClassOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_12ClassOptionsES1_")
//</editor-fold>
public static /*inline*/ /*ClassOptions*//*uint16_t*/char $bitand_ClassOptions(/*ClassOptions*//*uint16_t*/char a, /*ClassOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 207,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_12ClassOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_12ClassOptionsE")
//</editor-fold>
public static /*inline*/ /*ClassOptions*//*uint16_t*/char $bitnot_ClassOptions(/*ClassOptions*//*uint16_t*/char a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 207,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_12ClassOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_12ClassOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ClassOptions /*&*/> $orassign_type$ref$ClassOptions_ClassOptions(final type$ref<ClassOptions /*&*/> a, /*ClassOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 207,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_12ClassOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_12ClassOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ClassOptions /*&*/> $andassign_type$ref$ClassOptions_ClassOptions(final type$ref<ClassOptions /*&*/> a, /*ClassOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 231,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_21FrameProcedureOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_21FrameProcedureOptionsES1_")
//</editor-fold>
public static /*inline*/ /*FrameProcedureOptions*//*uint32_t*/int $bitor_FrameProcedureOptions(/*FrameProcedureOptions*//*uint32_t*/int a, /*FrameProcedureOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 231,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_21FrameProcedureOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_21FrameProcedureOptionsES1_")
//</editor-fold>
public static /*inline*/ /*FrameProcedureOptions*//*uint32_t*/int $bitand_FrameProcedureOptions(/*FrameProcedureOptions*//*uint32_t*/int a, /*FrameProcedureOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 231,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_21FrameProcedureOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_21FrameProcedureOptionsE")
//</editor-fold>
public static /*inline*/ /*FrameProcedureOptions*//*uint32_t*/int $bitnot_FrameProcedureOptions(/*FrameProcedureOptions*//*uint32_t*/int a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 231,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_21FrameProcedureOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_21FrameProcedureOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<FrameProcedureOptions /*&*/> $orassign_type$ref$FrameProcedureOptions_FrameProcedureOptions(final type$ref<FrameProcedureOptions /*&*/> a, /*FrameProcedureOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 231,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_21FrameProcedureOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_21FrameProcedureOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<FrameProcedureOptions /*&*/> $andassign_type$ref$FrameProcedureOptions_FrameProcedureOptions(final type$ref<FrameProcedureOptions /*&*/> a, /*FrameProcedureOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 239,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_15FunctionOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_15FunctionOptionsES1_")
//</editor-fold>
public static /*inline*/ /*FunctionOptions*/byte/*uint8_t*/ $bitor_FunctionOptions(/*FunctionOptions*/byte/*uint8_t*/ a, /*FunctionOptions*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 239,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_15FunctionOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_15FunctionOptionsES1_")
//</editor-fold>
public static /*inline*/ /*FunctionOptions*/byte/*uint8_t*/ $bitand_FunctionOptions(/*FunctionOptions*/byte/*uint8_t*/ a, /*FunctionOptions*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 239,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_15FunctionOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_15FunctionOptionsE")
//</editor-fold>
public static /*inline*/ /*FunctionOptions*/byte/*uint8_t*/ $bitnot_FunctionOptions(/*FunctionOptions*/byte/*uint8_t*/ a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 239,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_15FunctionOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_15FunctionOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<FunctionOptions /*&*/> $orassign_type$ref$FunctionOptions_FunctionOptions(final type$ref<FunctionOptions /*&*/> a, /*FunctionOptions*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 239,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_15FunctionOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_15FunctionOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<FunctionOptions /*&*/> $andassign_type$ref$FunctionOptions_FunctionOptions(final type$ref<FunctionOptions /*&*/> a, /*FunctionOptions*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 278,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_13MethodOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_13MethodOptionsES1_")
//</editor-fold>
public static /*inline*/ /*MethodOptions*//*uint16_t*/char $bitor_MethodOptions(/*MethodOptions*//*uint16_t*/char a, /*MethodOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 278,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_13MethodOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_13MethodOptionsES1_")
//</editor-fold>
public static /*inline*/ /*MethodOptions*//*uint16_t*/char $bitand_MethodOptions(/*MethodOptions*//*uint16_t*/char a, /*MethodOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 278,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_13MethodOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_13MethodOptionsE")
//</editor-fold>
public static /*inline*/ /*MethodOptions*//*uint16_t*/char $bitnot_MethodOptions(/*MethodOptions*//*uint16_t*/char a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 278,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_13MethodOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_13MethodOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<MethodOptions /*&*/> $orassign_type$ref$MethodOptions_MethodOptions(final type$ref<MethodOptions /*&*/> a, /*MethodOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 278,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_13MethodOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_13MethodOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<MethodOptions /*&*/> $andassign_type$ref$MethodOptions_MethodOptions(final type$ref<MethodOptions /*&*/> a, /*MethodOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 287,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_15ModifierOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_15ModifierOptionsES1_")
//</editor-fold>
public static /*inline*/ /*ModifierOptions*//*uint16_t*/char $bitor_ModifierOptions(/*ModifierOptions*//*uint16_t*/char a, /*ModifierOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 287,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_15ModifierOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_15ModifierOptionsES1_")
//</editor-fold>
public static /*inline*/ /*ModifierOptions*//*uint16_t*/char $bitand_ModifierOptions(/*ModifierOptions*//*uint16_t*/char a, /*ModifierOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 287,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_15ModifierOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_15ModifierOptionsE")
//</editor-fold>
public static /*inline*/ /*ModifierOptions*//*uint16_t*/char $bitnot_ModifierOptions(/*ModifierOptions*//*uint16_t*/char a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 287,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_15ModifierOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_15ModifierOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ModifierOptions /*&*/> $orassign_type$ref$ModifierOptions_ModifierOptions(final type$ref<ModifierOptions /*&*/> a, /*ModifierOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 287,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_15ModifierOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_15ModifierOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ModifierOptions /*&*/> $andassign_type$ref$ModifierOptions_ModifierOptions(final type$ref<ModifierOptions /*&*/> a, /*ModifierOptions*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 345,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_14PointerOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_14PointerOptionsES1_")
//</editor-fold>
public static /*inline*/ /*PointerOptions*//*uint32_t*/int $bitor_PointerOptions(/*PointerOptions*//*uint32_t*/int a, /*PointerOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 345,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_14PointerOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_14PointerOptionsES1_")
//</editor-fold>
public static /*inline*/ /*PointerOptions*//*uint32_t*/int $bitand_PointerOptions(/*PointerOptions*//*uint32_t*/int a, /*PointerOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 345,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_14PointerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_14PointerOptionsE")
//</editor-fold>
public static /*inline*/ /*PointerOptions*//*uint32_t*/int $bitnot_PointerOptions(/*PointerOptions*//*uint32_t*/int a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 345,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_14PointerOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_14PointerOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<PointerOptions /*&*/> $orassign_type$ref$PointerOptions_PointerOptions(final type$ref<PointerOptions /*&*/> a, /*PointerOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 345,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_14PointerOptionsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_14PointerOptionsES1_")
//</editor-fold>
public static /*inline*/ type$ref<PointerOptions /*&*/> $andassign_type$ref$PointerOptions_PointerOptions(final type$ref<PointerOptions /*&*/> a, /*PointerOptions*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 392,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_13LocalSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_13LocalSymFlagsES1_")
//</editor-fold>
public static /*inline*/ /*LocalSymFlags*//*uint16_t*/char $bitor_LocalSymFlags(/*LocalSymFlags*//*uint16_t*/char a, /*LocalSymFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 392,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_13LocalSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_13LocalSymFlagsES1_")
//</editor-fold>
public static /*inline*/ /*LocalSymFlags*//*uint16_t*/char $bitand_LocalSymFlags(/*LocalSymFlags*//*uint16_t*/char a, /*LocalSymFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 392,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_13LocalSymFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_13LocalSymFlagsE")
//</editor-fold>
public static /*inline*/ /*LocalSymFlags*//*uint16_t*/char $bitnot_LocalSymFlags(/*LocalSymFlags*//*uint16_t*/char a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 392,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_13LocalSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_13LocalSymFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<LocalSymFlags /*&*/> $orassign_type$ref$LocalSymFlags_LocalSymFlags(final type$ref<LocalSymFlags /*&*/> a, /*LocalSymFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 392,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_13LocalSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_13LocalSymFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<LocalSymFlags /*&*/> $andassign_type$ref$LocalSymFlags_LocalSymFlags(final type$ref<LocalSymFlags /*&*/> a, /*LocalSymFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 406,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_12ProcSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_12ProcSymFlagsES1_")
//</editor-fold>
public static /*inline*/ /*ProcSymFlags*/byte/*uint8_t*/ $bitor_ProcSymFlags(/*ProcSymFlags*/byte/*uint8_t*/ a, /*ProcSymFlags*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 406,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_12ProcSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_12ProcSymFlagsES1_")
//</editor-fold>
public static /*inline*/ /*ProcSymFlags*/byte/*uint8_t*/ $bitand_ProcSymFlags(/*ProcSymFlags*/byte/*uint8_t*/ a, /*ProcSymFlags*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 406,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_12ProcSymFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_12ProcSymFlagsE")
//</editor-fold>
public static /*inline*/ /*ProcSymFlags*/byte/*uint8_t*/ $bitnot_ProcSymFlags(/*ProcSymFlags*/byte/*uint8_t*/ a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 406,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_12ProcSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_12ProcSymFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ProcSymFlags /*&*/> $orassign_type$ref$ProcSymFlags_ProcSymFlags(final type$ref<ProcSymFlags /*&*/> a, /*ProcSymFlags*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 406,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_12ProcSymFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_12ProcSymFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ProcSymFlags /*&*/> $andassign_type$ref$ProcSymFlags_ProcSymFlags(final type$ref<ProcSymFlags /*&*/> a, /*ProcSymFlags*/byte/*uint8_t*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 420,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_16CompileSym2FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_16CompileSym2FlagsES1_")
//</editor-fold>
public static /*inline*/ /*CompileSym2Flags*//*uint32_t*/int $bitor_CompileSym2Flags(/*CompileSym2Flags*//*uint32_t*/int a, /*CompileSym2Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 420,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_16CompileSym2FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_16CompileSym2FlagsES1_")
//</editor-fold>
public static /*inline*/ /*CompileSym2Flags*//*uint32_t*/int $bitand_CompileSym2Flags(/*CompileSym2Flags*//*uint32_t*/int a, /*CompileSym2Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 420,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_16CompileSym2FlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_16CompileSym2FlagsE")
//</editor-fold>
public static /*inline*/ /*CompileSym2Flags*//*uint32_t*/int $bitnot_CompileSym2Flags(/*CompileSym2Flags*//*uint32_t*/int a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 420,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_16CompileSym2FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_16CompileSym2FlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<CompileSym2Flags /*&*/> $orassign_type$ref$CompileSym2Flags_CompileSym2Flags(final type$ref<CompileSym2Flags /*&*/> a, /*CompileSym2Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 420,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_16CompileSym2FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_16CompileSym2FlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<CompileSym2Flags /*&*/> $andassign_type$ref$CompileSym2Flags_CompileSym2Flags(final type$ref<CompileSym2Flags /*&*/> a, /*CompileSym2Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 437,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_16CompileSym3FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_16CompileSym3FlagsES1_")
//</editor-fold>
public static /*inline*/ /*CompileSym3Flags*//*uint32_t*/int $bitor_CompileSym3Flags(/*CompileSym3Flags*//*uint32_t*/int a, /*CompileSym3Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 437,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_16CompileSym3FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_16CompileSym3FlagsES1_")
//</editor-fold>
public static /*inline*/ /*CompileSym3Flags*//*uint32_t*/int $bitand_CompileSym3Flags(/*CompileSym3Flags*//*uint32_t*/int a, /*CompileSym3Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 437,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_16CompileSym3FlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_16CompileSym3FlagsE")
//</editor-fold>
public static /*inline*/ /*CompileSym3Flags*//*uint32_t*/int $bitnot_CompileSym3Flags(/*CompileSym3Flags*//*uint32_t*/int a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 437,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_16CompileSym3FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_16CompileSym3FlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<CompileSym3Flags /*&*/> $orassign_type$ref$CompileSym3Flags_CompileSym3Flags(final type$ref<CompileSym3Flags /*&*/> a, /*CompileSym3Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 437,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_16CompileSym3FlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_16CompileSym3FlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<CompileSym3Flags /*&*/> $andassign_type$ref$CompileSym3Flags_CompileSym3Flags(final type$ref<CompileSym3Flags /*&*/> a, /*CompileSym3Flags*//*uint32_t*/int b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 447,
 FQN="llvm::codeview::operator|", NM="_ZN4llvm8codevieworENS0_11ExportFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieworENS0_11ExportFlagsES1_")
//</editor-fold>
public static /*inline*/ /*ExportFlags*//*uint16_t*/char $bitor_ExportFlags(/*ExportFlags*//*uint16_t*/char a, /*ExportFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 447,
 FQN="llvm::codeview::operator&", NM="_ZN4llvm8codeviewanENS0_11ExportFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewanENS0_11ExportFlagsES1_")
//</editor-fold>
public static /*inline*/ /*ExportFlags*//*uint16_t*/char $bitand_ExportFlags(/*ExportFlags*//*uint16_t*/char a, /*ExportFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator~">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 447,
 FQN="llvm::codeview::operator~", NM="_ZN4llvm8codeviewcoENS0_11ExportFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewcoENS0_11ExportFlagsE")
//</editor-fold>
public static /*inline*/ /*ExportFlags*//*uint16_t*/char $bitnot_ExportFlags(/*ExportFlags*//*uint16_t*/char a) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator|=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 447,
 FQN="llvm::codeview::operator|=", NM="_ZN4llvm8codeviewoRERNS0_11ExportFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewoRERNS0_11ExportFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ExportFlags /*&*/> $orassign_type$ref$ExportFlags_ExportFlags(final type$ref<ExportFlags /*&*/> a, /*ExportFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator&=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/CodeView.h", line = 447,
 FQN="llvm::codeview::operator&=", NM="_ZN4llvm8codeviewaNERNS0_11ExportFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewaNERNS0_11ExportFlagsES1_")
//</editor-fold>
public static /*inline*/ type$ref<ExportFlags /*&*/> $andassign_type$ref$ExportFlags_ExportFlags(final type$ref<ExportFlags /*&*/> a, /*ExportFlags*//*uint16_t*/char b) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Consumes sizeof(T) bytes from the given byte sequence. Returns an error if
/// there are not enough bytes remaining. Reinterprets the consumed bytes as a
/// T object and points 'Res' at them.
/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consumeObject">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 41,
 FQN="llvm::codeview::consumeObject", NM="Tpl__ZN4llvm8codeview13consumeObjectERT0_RPKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview13consumeObjectERT0_RPKT_")
//</editor-fold>
public static /*inline*/ </*typename*/ T, /*typename*/ U> std.error_code consumeObject(final U /*&*/ Data, final /*const*/ T /*P*/ /*&*/ Res) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 49,
 FQN="llvm::codeview::consume", NM="_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEE")
//</editor-fold>
public static /*inline*/ std.error_code consume(final ArrayRefUChar/*&*/ Data) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Decodes an arbitrary object whose layout matches that of the underlying
/// byte sequence, and returns a pointer to the object.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 74,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERPT_")
//</editor-fold>
public static </*typename*/ T> std.error_code consume_ArrayRefUChar_T$R(final ArrayRefUChar/*&*/ Data, final T /*P*/ /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_conditional">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 92,
 FQN="llvm::codeview::serialize_conditional", NM="Tpl__ZN4llvm8codeview21serialize_conditionalERT_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview21serialize_conditionalERT_T0_")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> serialize_conditional_impl<T, U> serialize_conditional(final T /*&*/ Item, U Func) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_array">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 185,
 FQN="llvm::codeview::serialize_array", NM="Tpl__ZN4llvm8codeview15serialize_arrayERNS_8ArrayRefIT_EET0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview15serialize_arrayERNS_8ArrayRefIT_EET0_")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> serialize_array_impl<T, U> serialize_array(final ArrayRef<T> /*&*/ Item, U Func) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_null_term_string_array">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 189,
 FQN="llvm::codeview::serialize_null_term_string_array", NM="_ZN4llvm8codeview32serialize_null_term_string_arrayERSt6vectorINS_9StringRefESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview32serialize_null_term_string_arrayERSt6vectorINS_9StringRefESaIS2_EE")
//</editor-fold>
public static /*inline*/ serialize_null_term_string_array_impl serialize_null_term_string_array(final std.vector<StringRef> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_array_tail">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 195,
 FQN="llvm::codeview::serialize_array_tail", NM="Tpl__ZN4llvm8codeview20serialize_array_tailERSt6vectorIT_SaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview20serialize_array_tailERSt6vectorIT_SaIS2_EE")
//</editor-fold>
public static </*typename*/ T> serialize_vector_tail_impl<T> serialize_array_tail(final std.vector<T> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_array_tail">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 200,
 FQN="llvm::codeview::serialize_array_tail", NM="Tpl__ZN4llvm8codeview20serialize_array_tailERNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview20serialize_array_tailERNS_8ArrayRefIT_EE")
//</editor-fold>
public static </*typename*/ T> serialize_arrayref_tail_impl<T> serialize_array_tail(final ArrayRef<T> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::serialize_numeric">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 204,
 FQN="llvm::codeview::serialize_numeric", NM="Tpl__ZN4llvm8codeview17serialize_numericERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview17serialize_numericERT_")
//</editor-fold>
public static </*typename*/ T> serialize_numeric_impl<T> serialize_numeric(final T /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 229,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_conditional_implIT_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_conditional_implIT_T0_EE")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> std.error_code consume_ArrayRefUChar_serialize_conditional_impl$T$U$C(final ArrayRefUChar/*&*/ Data, 
                                                      final /*const*/ serialize_conditional_impl<T, U> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 235,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_20serialize_array_implIT_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_20serialize_array_implIT_T0_EE")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U> std.error_code consume_ArrayRefUChar_serialize_array_impl$T$U$C(final ArrayRefUChar/*&*/ Data, 
                                                final /*const*/ serialize_array_impl<T, U> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 240,
 FQN="llvm::codeview::consume", NM="_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_37serialize_null_term_string_array_implE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_37serialize_null_term_string_array_implE")
//</editor-fold>
public static /*inline*/ std.error_code consume_ArrayRefUChar_serialize_null_term_string_array_impl$C(final ArrayRefUChar/*&*/ Data, 
                                                             final /*const*/ serialize_null_term_string_array_impl /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 247,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_vector_tail_implIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_26serialize_vector_tail_implIT_EE")
//</editor-fold>
public static </*typename*/ T> std.error_code consume_ArrayRefUChar_serialize_vector_tail_impl$T$C(final ArrayRefUChar/*&*/ Data, 
                                                    final /*const*/ serialize_vector_tail_impl<T> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 253,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_28serialize_arrayref_tail_implIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_28serialize_arrayref_tail_implIT_EE")
//</editor-fold>
public static </*typename*/ T> std.error_code consume_ArrayRefUChar_serialize_arrayref_tail_impl$T$C(final ArrayRefUChar/*&*/ Data, 
                                                      final /*const*/ serialize_arrayref_tail_impl<T> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 259,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_22serialize_numeric_implIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEERKNS0_22serialize_numeric_implIT_EE")
//</editor-fold>
public static </*typename*/ T> std.error_code consume_ArrayRefUChar_serialize_numeric_impl$T$C(final ArrayRefUChar/*&*/ Data, 
                                                final /*const*/ serialize_numeric_impl<T> /*&*/ Item) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename T, typename U, typename ... Args> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::consume">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/RecordSerialization.h", line = 265,
 FQN="llvm::codeview::consume", NM="Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEEOT_OT0_DpOT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=Tpl__ZN4llvm8codeview7consumeERNS_8ArrayRefIhEEOT_OT0_DpOT1_")
//</editor-fold>
public static </*typename*/ T, /*typename*/ U, /*typename*/ /*...*/ Args> std.error_code consume$T(final ArrayRefUChar/*&*/ Data, final T /*&&*/X, final U /*&&*/Y, 
         Args /*&&*/...Rest) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/SymbolRecord.h", line = 597,
 FQN="llvm::codeview::(anonymous)", NM="_ZN4llvm8codeviewE_SymbolRecord_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewE_SymbolRecord_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint16_t {*/
  public static final /*uint16_t*/char MaxDefRange = $int2ushort(0xf000);
/*}*/
} // END OF class CodeviewGlobals
