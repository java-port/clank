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
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type MCSectionMachOStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCSectionMachOStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_Unnamed_struct19;_Unnamed_struct20;_ZL22SectionAttrDescriptors;_ZL22SectionTypeDescriptors; -static-type=MCSectionMachOStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCSectionMachOStatics {

public static class Unnamed_struct1 {
  public char$ptr AssemblerName;
  public char$ptr EnumName;

  public Unnamed_struct1(char$ptr AssemblerName, char$ptr EnumName) {
    this.AssemblerName = AssemblerName;
    this.EnumName = EnumName;
  }
  
}
/// SectionTypeDescriptors - These are strings that describe the various section
/// types.  This *must* be kept in order with and stay synchronized with the
/// section type list.
//<editor-fold defaultstate="collapsed" desc="SectionTypeDescriptors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 19,
 FQN="SectionTypeDescriptors", NM="_ZL22SectionTypeDescriptors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZL22SectionTypeDescriptors")
//</editor-fold>
public static Unnamed_struct1 SectionTypeDescriptors[/*22*/] = new Unnamed_struct1 [/*22*/] {
  new Unnamed_struct1($("regular"), $("S_REGULAR")),  // 0x00
  new Unnamed_struct1(null, $("S_ZEROFILL")),  // 0x01
  new Unnamed_struct1($("cstring_literals"), $("S_CSTRING_LITERALS")),  // 0x02
  new Unnamed_struct1($("4byte_literals"), $("S_4BYTE_LITERALS")),  // 0x03
  new Unnamed_struct1($("8byte_literals"), $("S_8BYTE_LITERALS")),  // 0x04
  new Unnamed_struct1($("literal_pointers"), $("S_LITERAL_POINTERS")),  // 0x05
  new Unnamed_struct1($("non_lazy_symbol_pointers"), $("S_NON_LAZY_SYMBOL_POINTERS")),  // 0x06
  new Unnamed_struct1($("lazy_symbol_pointers"), $("S_LAZY_SYMBOL_POINTERS")),  // 0x07
  new Unnamed_struct1($("symbol_stubs"), $("S_SYMBOL_STUBS")),  // 0x08
  new Unnamed_struct1($("mod_init_funcs"), $("S_MOD_INIT_FUNC_POINTERS")),  // 0x09
  new Unnamed_struct1($("mod_term_funcs"), $("S_MOD_TERM_FUNC_POINTERS")),  // 0x0A
  new Unnamed_struct1($("coalesced"), $("S_COALESCED")),  // 0x0B
  new Unnamed_struct1(null, /*FIXME??*/ $("S_GB_ZEROFILL")),  // 0x0C
  new Unnamed_struct1($("interposing"), $("S_INTERPOSING")),  // 0x0D
  new Unnamed_struct1($("16byte_literals"), $("S_16BYTE_LITERALS")),  // 0x0E
  new Unnamed_struct1(null, /*FIXME??*/ $("S_DTRACE_DOF")),  // 0x0F
  new Unnamed_struct1(null, /*FIXME??*/ $("S_LAZY_DYLIB_SYMBOL_POINTERS")),  // 0x10
  new Unnamed_struct1($("thread_local_regular"), $("S_THREAD_LOCAL_REGULAR")),  // 0x11
  new Unnamed_struct1($("thread_local_zerofill"), $("S_THREAD_LOCAL_ZEROFILL")),  // 0x12
  new Unnamed_struct1($("thread_local_variables"), $("S_THREAD_LOCAL_VARIABLES")),  // 0x13
  new Unnamed_struct1(
    $("thread_local_variable_pointers"), 
    $("S_THREAD_LOCAL_VARIABLE_POINTERS")),  // 0x14
  new Unnamed_struct1(
    $("thread_local_init_function_pointers"), 
    $("S_THREAD_LOCAL_INIT_FUNCTION_POINTERS")) // 0x15
};

public static class Unnamed_struct2 {
  public int AttrFlag;
  public char$ptr AssemblerName;
  public char$ptr EnumName;

  public Unnamed_struct2(int AttrFlag, char$ptr AssemblerName, char$ptr EnumName) {
    this.AttrFlag = AttrFlag;
    this.AssemblerName = AssemblerName;
    this.EnumName = EnumName;
  }  
}
/// SectionAttrDescriptors - This is an array of descriptors for section
/// attributes.  Unlike the SectionTypeDescriptors, this is not directly indexed
/// by attribute, instead it is searched.
//<editor-fold defaultstate="collapsed" desc="SectionAttrDescriptors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 52,
 FQN="SectionAttrDescriptors", NM="_ZL22SectionAttrDescriptors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZL22SectionAttrDescriptors")
//</editor-fold>
public static Unnamed_struct2 SectionAttrDescriptors[/*11*/] = new Unnamed_struct2 [/*11*/] {
  new Unnamed_struct2(MachO.S_ATTR_PURE_INSTRUCTIONS, $("pure_instructions"), $("S_ATTR_PURE_INSTRUCTIONS")), 
  new Unnamed_struct2(MachO.S_ATTR_NO_TOC, $("no_toc"), $("S_ATTR_NO_TOC")), 
  new Unnamed_struct2(MachO.S_ATTR_STRIP_STATIC_SYMS, $("strip_static_syms"), $("S_ATTR_STRIP_STATIC_SYMS")), 
  new Unnamed_struct2(MachO.S_ATTR_NO_DEAD_STRIP, $("no_dead_strip"), $("S_ATTR_NO_DEAD_STRIP")), 
  new Unnamed_struct2(MachO.S_ATTR_LIVE_SUPPORT, $("live_support"), $("S_ATTR_LIVE_SUPPORT")), 
  new Unnamed_struct2(MachO.S_ATTR_SELF_MODIFYING_CODE, $("self_modifying_code"), $("S_ATTR_SELF_MODIFYING_CODE")), 
  new Unnamed_struct2(MachO.S_ATTR_DEBUG, $("debug"), $("S_ATTR_DEBUG")), 
  new Unnamed_struct2(MachO.S_ATTR_SOME_INSTRUCTIONS, null, $("S_ATTR_SOME_INSTRUCTIONS")), 
  /*FIXME*/
  new Unnamed_struct2(MachO.S_ATTR_EXT_RELOC, null, $("S_ATTR_EXT_RELOC")), 
  /*FIXME*/
  new Unnamed_struct2(MachO.S_ATTR_LOC_RELOC, null, $("S_ATTR_LOC_RELOC")), 
  new Unnamed_struct2(0, $("none"), null) // used if section has no attributes but has a stub size
};
} // END OF class MCSectionMachOStatics
