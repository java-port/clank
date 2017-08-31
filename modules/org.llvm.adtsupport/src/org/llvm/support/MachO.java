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
package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type MachO">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.MachO",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp ${LLVM_SRC}/llvm/lib/Support/Path.cpp -nm=_ZN4llvm5MachO10BindOpcodeE;_ZN4llvm5MachO10RebaseTypeE;_ZN4llvm5MachO10fat_headerE;_ZN4llvm5MachO10mmst_reg_tE;_ZN4llvm5MachO10nlist_baseE;_ZN4llvm5MachO10section_64E;_ZN4llvm5MachO10swapStructERNS0_10fat_headerE;_ZN4llvm5MachO10swapStructERNS0_10nlist_baseE;_ZN4llvm5MachO10swapStructERNS0_10section_64E;_ZN4llvm5MachO10swapStructERNS0_11fat_arch_64E;_ZN4llvm5MachO10swapStructERNS0_11mach_headerE;_ZN4llvm5MachO10swapStructERNS0_12load_commandE;_ZN4llvm5MachO10swapStructERNS0_12uuid_commandE;_ZN4llvm5MachO10swapStructERNS0_13dylib_commandE;_ZN4llvm5MachO10swapStructERNS0_13ident_commandE;_ZN4llvm5MachO10swapStructERNS0_13rpath_commandE;_ZN4llvm5MachO10swapStructERNS0_14fvmlib_commandE;_ZN4llvm5MachO10swapStructERNS0_14mach_header_64E;_ZN4llvm5MachO10swapStructERNS0_14symseg_commandE;_ZN4llvm5MachO10swapStructERNS0_14symtab_commandE;_ZN4llvm5MachO10swapStructERNS0_14thread_commandE;_ZN4llvm5MachO10swapStructERNS0_15fvmfile_commandE;_ZN4llvm5MachO10swapStructERNS0_15segment_commandE;_ZN4llvm5MachO10swapStructERNS0_15x86_state_hdr_tE;_ZN4llvm5MachO10swapStructERNS0_16dylinker_commandE;_ZN4llvm5MachO10swapStructERNS0_16dysymtab_commandE;_ZN4llvm5MachO10swapStructERNS0_16routines_commandE;_ZN4llvm5MachO10swapStructERNS0_17dyld_info_commandE;_ZN4llvm5MachO10swapStructERNS0_17x86_float_state_tE;_ZN4llvm5MachO10swapStructERNS0_18data_in_code_entryE;_ZN4llvm5MachO10swapStructERNS0_18segment_command_64E;_ZN4llvm5MachO10swapStructERNS0_18sub_client_commandE;_ZN4llvm5MachO10swapStructERNS0_18x86_thread_state_tE;_ZN4llvm5MachO10swapStructERNS0_19any_relocation_infoE;_ZN4llvm5MachO10swapStructERNS0_19entry_point_commandE;_ZN4llvm5MachO10swapStructERNS0_19routines_command_64E;_ZN4llvm5MachO10swapStructERNS0_19sub_library_commandE;_ZN4llvm5MachO10swapStructERNS0_19version_min_commandE;_ZN4llvm5MachO10swapStructERNS0_19x86_float_state64_tE;_ZN4llvm5MachO10swapStructERNS0_20sub_umbrella_commandE;_ZN4llvm5MachO10swapStructERNS0_20x86_thread_state64_tE;_ZN4llvm5MachO10swapStructERNS0_21linkedit_data_commandE;_ZN4llvm5MachO10swapStructERNS0_21linker_option_commandE;_ZN4llvm5MachO10swapStructERNS0_21prebind_cksum_commandE;_ZN4llvm5MachO10swapStructERNS0_21sub_framework_commandE;_ZN4llvm5MachO10swapStructERNS0_21x86_exception_state_tE;_ZN4llvm5MachO10swapStructERNS0_22prebound_dylib_commandE;_ZN4llvm5MachO10swapStructERNS0_22source_version_commandE;_ZN4llvm5MachO10swapStructERNS0_22twolevel_hints_commandE;_ZN4llvm5MachO10swapStructERNS0_23encryption_info_commandE;_ZN4llvm5MachO10swapStructERNS0_23x86_exception_state64_tE;_ZN4llvm5MachO10swapStructERNS0_26encryption_info_command_64E;_ZN4llvm5MachO10swapStructERNS0_5nlistE;_ZN4llvm5MachO10swapStructERNS0_6fvmlibE;_ZN4llvm5MachO10swapStructERNS0_7sectionE;_ZN4llvm5MachO10swapStructERNS0_8fat_archE;_ZN4llvm5MachO10swapStructERNS0_8nlist_64E;_ZN4llvm5MachO10swapStructERj;_ZN4llvm5MachO11SectionTypeE;_ZN4llvm5MachO11fat_arch_64E;_ZN4llvm5MachO11fp_status_tE;_ZN4llvm5MachO11mach_headerE;_ZN4llvm5MachO12RebaseOpcodeE;_ZN4llvm5MachO12dylib_moduleE;_ZN4llvm5MachO12fp_control_tE;_ZN4llvm5MachO12load_commandE;_ZN4llvm5MachO12uuid_commandE;_ZN4llvm5MachO13CPUSubTypeARME;_ZN4llvm5MachO13CPUSubTypeX86E;_ZN4llvm5MachO13dylib_commandE;_ZN4llvm5MachO13ident_commandE;_ZN4llvm5MachO13rpath_commandE;_ZN4llvm5MachO13twolevel_hintE;_ZN4llvm5MachO14DataRegionTypeE;_ZN4llvm5MachO14HeaderFileTypeE;_ZN4llvm5MachO14SectionOrdinalE;_ZN4llvm5MachO14fvmlib_commandE;_ZN4llvm5MachO14mach_header_64E;_ZN4llvm5MachO14symseg_commandE;_ZN4llvm5MachO14symtab_commandE;_ZN4llvm5MachO14thread_commandE;_ZN4llvm5MachO14tlv_descriptorE;_ZN4llvm5MachO15CPUSubTypeARM64E;_ZN4llvm5MachO15CPUSubTypeSPARCE;_ZN4llvm5MachO15LoadCommandTypeE;_ZN4llvm5MachO15dylib_module_64E;_ZN4llvm5MachO15dylib_referenceE;_ZN4llvm5MachO15fvmfile_commandE;_ZN4llvm5MachO15relocation_infoE;_ZN4llvm5MachO15segment_commandE;_ZN4llvm5MachO15x86_state_hdr_tE;_ZN4llvm5MachO16BindSpecialDylibE;_ZN4llvm5MachO16ExportSymbolKindE;_ZN4llvm5MachO16X86ThreadFlavorsE;_ZN4llvm5MachO16dylinker_commandE;_ZN4llvm5MachO16dysymtab_commandE;_ZN4llvm5MachO16routines_commandE;_ZN4llvm5MachO17CPUSubTypePowerPCE;_ZN4llvm5MachO17dyld_info_commandE;_ZN4llvm5MachO17tlv_descriptor_32E;_ZN4llvm5MachO17tlv_descriptor_64E;_ZN4llvm5MachO17x86_float_state_tE;_ZN4llvm5MachO17x86_fp_control_rcE;_ZN4llvm5MachO18RelocationInfoTypeE;_ZN4llvm5MachO18data_in_code_entryE;_ZN4llvm5MachO18macho_load_commandE;_ZN4llvm5MachO18segment_command_64E;_ZN4llvm5MachO18sub_client_commandE;_ZN4llvm5MachO18x86_thread_state_tE;_ZN4llvm5MachO19any_relocation_infoE;_ZN4llvm5MachO19entry_point_commandE;_ZN4llvm5MachO19routines_command_64E;_ZN4llvm5MachO19sub_library_commandE;_ZN4llvm5MachO19version_min_commandE;_ZN4llvm5MachO19x86_float_state64_tE;_ZN4llvm5MachO20sub_umbrella_commandE;_ZN4llvm5MachO20x86_thread_state64_tE;_ZN4llvm5MachO21linkedit_data_commandE;_ZN4llvm5MachO21linker_option_commandE;_ZN4llvm5MachO21prebind_cksum_commandE;_ZN4llvm5MachO21sub_framework_commandE;_ZN4llvm5MachO21x86_exception_state_tE;_ZN4llvm5MachO21x86_fp_control_precisE;_ZN4llvm5MachO22prebound_dylib_commandE;_ZN4llvm5MachO22source_version_commandE;_ZN4llvm5MachO22twolevel_hints_commandE;_ZN4llvm5MachO23dylib_table_of_contentsE;_ZN4llvm5MachO23encryption_info_commandE;_ZN4llvm5MachO23x86_exception_state64_tE;_ZN4llvm5MachO25scattered_relocation_infoE;_ZN4llvm5MachO26encryption_info_command_64E;_ZN4llvm5MachO5dylibE;_ZN4llvm5MachO5nlistE;_ZN4llvm5MachO6fvmlibE;_ZN4llvm5MachO7CPUTypeE;_ZN4llvm5MachO7sectionE;_ZN4llvm5MachO8BindTypeE;_ZN4llvm5MachO8StabTypeE;_ZN4llvm5MachO8fat_archE;_ZN4llvm5MachO8nlist_64E;_ZN4llvm5MachO9NListTypeE;_ZN4llvm5MachO9xmm_reg_tE;_ZN4llvm5MachOE_MachO_h_Unnamed_enum;_ZN4llvm5MachOE_MachO_h_Unnamed_enum10;_ZN4llvm5MachOE_MachO_h_Unnamed_enum14;_ZN4llvm5MachOE_MachO_h_Unnamed_enum16;_ZN4llvm5MachOE_MachO_h_Unnamed_enum18;_ZN4llvm5MachOE_MachO_h_Unnamed_enum2;_ZN4llvm5MachOE_MachO_h_Unnamed_enum21;_ZN4llvm5MachOE_MachO_h_Unnamed_enum23;_ZN4llvm5MachOE_MachO_h_Unnamed_enum25;_ZN4llvm5MachOE_MachO_h_Unnamed_enum26;_ZN4llvm5MachOE_MachO_h_Unnamed_enum28;_ZN4llvm5MachOE_MachO_h_Unnamed_enum3;_ZN4llvm5MachOE_MachO_h_Unnamed_enum30;_ZN4llvm5MachOE_MachO_h_Unnamed_enum5;_ZN4llvm5MachOE_MachO_h_Unnamed_enum7;_ZN4llvm5MachOL14GET_COMM_ALIGNEt;_ZN4llvm5MachOL14SET_COMM_ALIGNERth;_ZN4llvm5MachOL17CPU_SUBTYPE_INTELEii;_ZN4llvm5MachOL19GET_LIBRARY_ORDINALEt;_ZN4llvm5MachOL19SET_LIBRARY_ORDINALERth;_ZN4llvm5MachOL21x86_FLOAT_STATE_COUNTE;_ZN4llvm5MachOL22x86_THREAD_STATE_COUNTE;_ZN4llvm5MachOL23CPU_SUBTYPE_INTEL_MODELENS0_13CPUSubTypeX86E;_ZN4llvm5MachOL23x86_FLOAT_STATE64_COUNTE;_ZN4llvm5MachOL24CPU_SUBTYPE_INTEL_FAMILYENS0_13CPUSubTypeX86E;_ZN4llvm5MachOL24x86_THREAD_STATE64_COUNTE;_ZN4llvm5MachOL25x86_EXCEPTION_STATE_COUNTE;_ZN4llvm5MachOL27x86_EXCEPTION_STATE64_COUNTE; -static-type=MachO -package=org.llvm.support")
//</editor-fold>
public final class MachO {

// Enums from <mach-o/loader.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 24,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Constants for the "magic" field in llvm::MachO::mach_header and
  // llvm::MachO::mach_header_64
  public static final /*uint32_t*/int MH_MAGIC = 0xFEEDFACE/*U*/;
  public static final /*uint32_t*/int MH_CIGAM = 0xCEFAEDFE/*U*/;
  public static final /*uint32_t*/int MH_MAGIC_64 = 0xFEEDFACF/*U*/;
  public static final /*uint32_t*/int MH_CIGAM_64 = 0xCFFAEDFE/*U*/;
  public static final /*uint32_t*/int FAT_MAGIC = 0xCAFEBABE/*U*/;
  public static final /*uint32_t*/int FAT_CIGAM = 0xBEBAFECA/*U*/;
  public static final /*uint32_t*/int FAT_MAGIC_64 = 0xCAFEBABF/*U*/;
  public static final /*uint32_t*/int FAT_CIGAM_64 = 0xBFBAFECA/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::HeaderFileType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 37,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 35,
 FQN="llvm::MachO::HeaderFileType", NM="_ZN4llvm5MachO14HeaderFileTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14HeaderFileTypeE")
//</editor-fold>
public static final class/*enum*/ HeaderFileType {
  // Constants for the "filetype" field in llvm::MachO::mach_header and
  // llvm::MachO::mach_header_64
  public static final /*uint*/int MH_OBJECT = 0x1/*U*/;
  public static final /*uint*/int MH_EXECUTE = 0x2/*U*/;
  public static final /*uint*/int MH_FVMLIB = 0x3/*U*/;
  public static final /*uint*/int MH_CORE = 0x4/*U*/;
  public static final /*uint*/int MH_PRELOAD = 0x5/*U*/;
  public static final /*uint*/int MH_DYLIB = 0x6/*U*/;
  public static final /*uint*/int MH_DYLINKER = 0x7/*U*/;
  public static final /*uint*/int MH_BUNDLE = 0x8/*U*/;
  public static final /*uint*/int MH_DYLIB_STUB = 0x9/*U*/;
  public static final /*uint*/int MH_DSYM = 0xA/*U*/;
  public static final /*uint*/int MH_KEXT_BUNDLE = 0xB/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 53,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 51,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum2")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // Constant bits for the "flags" field in llvm::MachO::mach_header and
  // llvm::MachO::mach_header_64
  public static final /*uint*/int MH_NOUNDEFS = 0x00000001/*U*/;
  public static final /*uint*/int MH_INCRLINK = 0x00000002/*U*/;
  public static final /*uint*/int MH_DYLDLINK = 0x00000004/*U*/;
  public static final /*uint*/int MH_BINDATLOAD = 0x00000008/*U*/;
  public static final /*uint*/int MH_PREBOUND = 0x00000010/*U*/;
  public static final /*uint*/int MH_SPLIT_SEGS = 0x00000020/*U*/;
  public static final /*uint*/int MH_LAZY_INIT = 0x00000040/*U*/;
  public static final /*uint*/int MH_TWOLEVEL = 0x00000080/*U*/;
  public static final /*uint*/int MH_FORCE_FLAT = 0x00000100/*U*/;
  public static final /*uint*/int MH_NOMULTIDEFS = 0x00000200/*U*/;
  public static final /*uint*/int MH_NOFIXPREBINDING = 0x00000400/*U*/;
  public static final /*uint*/int MH_PREBINDABLE = 0x00000800/*U*/;
  public static final /*uint*/int MH_ALLMODSBOUND = 0x00001000/*U*/;
  public static final /*uint*/int MH_SUBSECTIONS_VIA_SYMBOLS = 0x00002000/*U*/;
  public static final /*uint*/int MH_CANONICAL = 0x00004000/*U*/;
  public static final /*uint*/int MH_WEAK_DEFINES = 0x00008000/*U*/;
  public static final /*uint*/int MH_BINDS_TO_WEAK = 0x00010000/*U*/;
  public static final /*uint*/int MH_ALLOW_STACK_EXECUTION = 0x00020000/*U*/;
  public static final /*uint*/int MH_ROOT_SAFE = 0x00040000/*U*/;
  public static final /*uint*/int MH_SETUID_SAFE = 0x00080000/*U*/;
  public static final /*uint*/int MH_NO_REEXPORTED_DYLIBS = 0x00100000/*U*/;
  public static final /*uint*/int MH_PIE = 0x00200000/*U*/;
  public static final /*uint*/int MH_DEAD_STRIPPABLE_DYLIB = 0x00400000/*U*/;
  public static final /*uint*/int MH_HAS_TLV_DESCRIPTORS = 0x00800000/*U*/;
  public static final /*uint*/int MH_NO_HEAP_EXECUTION = 0x01000000/*U*/;
  public static final /*uint*/int MH_APP_EXTENSION_SAFE = 0x02000000/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 84,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 82,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum3",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum3")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Flags for the "cmd" field in llvm::MachO::load_command
  public static final /*uint32_t*/int LC_REQ_DYLD = 0x80000000/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::LoadCommandType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 92,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 87,
 FQN="llvm::MachO::LoadCommandType", NM="_ZN4llvm5MachO15LoadCommandTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15LoadCommandTypeE")
//</editor-fold>
public static final class/*enum*/ LoadCommandType/* : uint32_t*/ {
  public static final /*uint32_t*/int LC_SEGMENT = 0x1/*U*/;
  public static final /*uint32_t*/int LC_SYMTAB = 0x2/*U*/;
  public static final /*uint32_t*/int LC_SYMSEG = 0x3/*U*/;
  public static final /*uint32_t*/int LC_THREAD = 0x4/*U*/;
  public static final /*uint32_t*/int LC_UNIXTHREAD = 0x5/*U*/;
  public static final /*uint32_t*/int LC_LOADFVMLIB = 0x6/*U*/;
  public static final /*uint32_t*/int LC_IDFVMLIB = 0x7/*U*/;
  public static final /*uint32_t*/int LC_IDENT = 0x8/*U*/;
  public static final /*uint32_t*/int LC_FVMFILE = 0x9/*U*/;
  public static final /*uint32_t*/int LC_PREPAGE = 0xA/*U*/;
  public static final /*uint32_t*/int LC_DYSYMTAB = 0xB/*U*/;
  public static final /*uint32_t*/int LC_LOAD_DYLIB = 0xC/*U*/;
  public static final /*uint32_t*/int LC_ID_DYLIB = 0xD/*U*/;
  public static final /*uint32_t*/int LC_LOAD_DYLINKER = 0xE/*U*/;
  public static final /*uint32_t*/int LC_ID_DYLINKER = 0xF/*U*/;
  public static final /*uint32_t*/int LC_PREBOUND_DYLIB = 0x10/*U*/;
  public static final /*uint32_t*/int LC_ROUTINES = 0x11/*U*/;
  public static final /*uint32_t*/int LC_SUB_FRAMEWORK = 0x12/*U*/;
  public static final /*uint32_t*/int LC_SUB_UMBRELLA = 0x13/*U*/;
  public static final /*uint32_t*/int LC_SUB_CLIENT = 0x14/*U*/;
  public static final /*uint32_t*/int LC_SUB_LIBRARY = 0x15/*U*/;
  public static final /*uint32_t*/int LC_TWOLEVEL_HINTS = 0x16/*U*/;
  public static final /*uint32_t*/int LC_PREBIND_CKSUM = 0x17/*U*/;
  public static final /*uint32_t*/int LC_LOAD_WEAK_DYLIB = 0x80000018/*U*/;
  public static final /*uint32_t*/int LC_SEGMENT_64 = 0x19/*U*/;
  public static final /*uint32_t*/int LC_ROUTINES_64 = 0x1A/*U*/;
  public static final /*uint32_t*/int LC_UUID = 0x1B/*U*/;
  public static final /*uint32_t*/int LC_RPATH = 0x8000001C/*U*/;
  public static final /*uint32_t*/int LC_CODE_SIGNATURE = 0x1D/*U*/;
  public static final /*uint32_t*/int LC_SEGMENT_SPLIT_INFO = 0x1E/*U*/;
  public static final /*uint32_t*/int LC_REEXPORT_DYLIB = 0x8000001F/*U*/;
  public static final /*uint32_t*/int LC_LAZY_LOAD_DYLIB = 0x20/*U*/;
  public static final /*uint32_t*/int LC_ENCRYPTION_INFO = 0x21/*U*/;
  public static final /*uint32_t*/int LC_DYLD_INFO = 0x22/*U*/;
  public static final /*uint32_t*/int LC_DYLD_INFO_ONLY = 0x80000022/*U*/;
  public static final /*uint32_t*/int LC_LOAD_UPWARD_DYLIB = 0x80000023/*U*/;
  public static final /*uint32_t*/int LC_VERSION_MIN_MACOSX = 0x24/*U*/;
  public static final /*uint32_t*/int LC_VERSION_MIN_IPHONEOS = 0x25/*U*/;
  public static final /*uint32_t*/int LC_FUNCTION_STARTS = 0x26/*U*/;
  public static final /*uint32_t*/int LC_DYLD_ENVIRONMENT = 0x27/*U*/;
  public static final /*uint32_t*/int LC_MAIN = 0x80000028/*U*/;
  public static final /*uint32_t*/int LC_DATA_IN_CODE = 0x29/*U*/;
  public static final /*uint32_t*/int LC_SOURCE_VERSION = 0x2A/*U*/;
  public static final /*uint32_t*/int LC_DYLIB_CODE_SIGN_DRS = 0x2B/*U*/;
  public static final /*uint32_t*/int LC_ENCRYPTION_INFO_64 = 0x2C/*U*/;
  public static final /*uint32_t*/int LC_LINKER_OPTION = 0x2D/*U*/;
  public static final /*uint32_t*/int LC_LINKER_OPTIMIZATION_HINT = 0x2E/*U*/;
  public static final /*uint32_t*/int LC_VERSION_MIN_TVOS = 0x2F/*U*/;
  public static final /*uint32_t*/int LC_VERSION_MIN_WATCHOS = 0x30/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 98,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 140,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum5",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum5")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Constant bits for the "flags" field in llvm::MachO::segment_command
  public static final /*uint32_t*/int SG_HIGHVM = 0x1/*U*/;
  public static final /*uint32_t*/int SG_FVMLIB = 0x2/*U*/;
  public static final /*uint32_t*/int SG_NORELOC = 0x4/*U*/;
  public static final /*uint32_t*/int SG_PROTECTED_VERSION_1 = 0x8/*U*/;
  
  // Constant masks for the "flags" field in llvm::MachO::section and
  // llvm::MachO::section_64
  public static final /*uint32_t*/int SECTION_TYPE = 0x000000ff/*U*/; // SECTION_TYPE
  public static final /*uint32_t*/int SECTION_ATTRIBUTES = 0xffffff00/*U*/; // SECTION_ATTRIBUTES
  public static final /*uint32_t*/int SECTION_ATTRIBUTES_USR = 0xff000000/*U*/; // SECTION_ATTRIBUTES_USR
  public static final /*uint32_t*/int SECTION_ATTRIBUTES_SYS = 0x00ffff00/*U*/; // SECTION_ATTRIBUTES_SYS
/*}*/

/// These are the section type and attributes fields.  A MachO section can
/// have only one Type, but can have any of the attributes specified.
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::SectionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 115,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 157,
 FQN="llvm::MachO::SectionType", NM="_ZN4llvm5MachO11SectionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11SectionTypeE")
//</editor-fold>
public static final class/*enum*/ SectionType/* : uint32_t*/ {
  // Constant masks for the "flags[7:0]" field in llvm::MachO::section and
  // llvm::MachO::section_64 (mask "flags" with SECTION_TYPE)
  
  /// S_REGULAR - Regular section.
  public static final /*uint32_t*/int S_REGULAR = 0x00/*U*/;
  /// S_ZEROFILL - Zero fill on demand section.
  public static final /*uint32_t*/int S_ZEROFILL = 0x01/*U*/;
  /// S_CSTRING_LITERALS - Section with literal C strings.
  public static final /*uint32_t*/int S_CSTRING_LITERALS = 0x02/*U*/;
  /// S_4BYTE_LITERALS - Section with 4 byte literals.
  public static final /*uint32_t*/int S_4BYTE_LITERALS = 0x03/*U*/;
  /// S_8BYTE_LITERALS - Section with 8 byte literals.
  public static final /*uint32_t*/int S_8BYTE_LITERALS = 0x04/*U*/;
  /// S_LITERAL_POINTERS - Section with pointers to literals.
  public static final /*uint32_t*/int S_LITERAL_POINTERS = 0x05/*U*/;
  /// S_NON_LAZY_SYMBOL_POINTERS - Section with non-lazy symbol pointers.
  public static final /*uint32_t*/int S_NON_LAZY_SYMBOL_POINTERS = 0x06/*U*/;
  /// S_LAZY_SYMBOL_POINTERS - Section with lazy symbol pointers.
  public static final /*uint32_t*/int S_LAZY_SYMBOL_POINTERS = 0x07/*U*/;
  /// S_SYMBOL_STUBS - Section with symbol stubs, byte size of stub in
  /// the Reserved2 field.
  public static final /*uint32_t*/int S_SYMBOL_STUBS = 0x08/*U*/;
  /// S_MOD_INIT_FUNC_POINTERS - Section with only function pointers for
  /// initialization.
  public static final /*uint32_t*/int S_MOD_INIT_FUNC_POINTERS = 0x09/*U*/;
  /// S_MOD_TERM_FUNC_POINTERS - Section with only function pointers for
  /// termination.
  public static final /*uint32_t*/int S_MOD_TERM_FUNC_POINTERS = 0x0a/*U*/;
  /// S_COALESCED - Section contains symbols that are to be coalesced.
  public static final /*uint32_t*/int S_COALESCED = 0x0b/*U*/;
  /// S_GB_ZEROFILL - Zero fill on demand section (that can be larger than 4
  /// gigabytes).
  public static final /*uint32_t*/int S_GB_ZEROFILL = 0x0c/*U*/;
  /// S_INTERPOSING - Section with only pairs of function pointers for
  /// interposing.
  public static final /*uint32_t*/int S_INTERPOSING = 0x0d/*U*/;
  /// S_16BYTE_LITERALS - Section with only 16 byte literals.
  public static final /*uint32_t*/int S_16BYTE_LITERALS = 0x0e/*U*/;
  /// S_DTRACE_DOF - Section contains DTrace Object Format.
  public static final /*uint32_t*/int S_DTRACE_DOF = 0x0f/*U*/;
  /// S_LAZY_DYLIB_SYMBOL_POINTERS - Section with lazy symbol pointers to
  /// lazy loaded dylibs.
  public static final /*uint32_t*/int S_LAZY_DYLIB_SYMBOL_POINTERS = 0x10/*U*/;
  /// S_THREAD_LOCAL_REGULAR - Thread local data section.
  public static final /*uint32_t*/int S_THREAD_LOCAL_REGULAR = 0x11/*U*/;
  /// S_THREAD_LOCAL_ZEROFILL - Thread local zerofill section.
  public static final /*uint32_t*/int S_THREAD_LOCAL_ZEROFILL = 0x12/*U*/;
  /// S_THREAD_LOCAL_VARIABLES - Section with thread local variable
  /// structure data.
  public static final /*uint32_t*/int S_THREAD_LOCAL_VARIABLES = 0x13/*U*/;
  /// S_THREAD_LOCAL_VARIABLE_POINTERS - Section with pointers to thread
  /// local structures.
  public static final /*uint32_t*/int S_THREAD_LOCAL_VARIABLE_POINTERS = 0x14/*U*/;
  /// S_THREAD_LOCAL_INIT_FUNCTION_POINTERS - Section with thread local
  /// variable initialization pointers to functions.
  public static final /*uint32_t*/int S_THREAD_LOCAL_INIT_FUNCTION_POINTERS = 0x15/*U*/;
  
  public static final /*uint32_t*/int LAST_KNOWN_SECTION_TYPE = SectionType.S_THREAD_LOCAL_INIT_FUNCTION_POINTERS;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 176,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 218,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum7",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum7")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Constant masks for the "flags[31:24]" field in llvm::MachO::section and
  // llvm::MachO::section_64 (mask "flags" with SECTION_ATTRIBUTES_USR)
  
  /// S_ATTR_PURE_INSTRUCTIONS - Section contains only true machine
  /// instructions.
  public static final /*uint32_t*/int S_ATTR_PURE_INSTRUCTIONS = 0x80000000/*U*/;
  /// S_ATTR_NO_TOC - Section contains coalesced symbols that are not to be
  /// in a ranlib table of contents.
  public static final /*uint32_t*/int S_ATTR_NO_TOC = 0x40000000/*U*/;
  /// S_ATTR_STRIP_STATIC_SYMS - Ok to strip static symbols in this section
  /// in files with the MY_DYLDLINK flag.
  public static final /*uint32_t*/int S_ATTR_STRIP_STATIC_SYMS = 0x20000000/*U*/;
  /// S_ATTR_NO_DEAD_STRIP - No dead stripping.
  public static final /*uint32_t*/int S_ATTR_NO_DEAD_STRIP = 0x10000000/*U*/;
  /// S_ATTR_LIVE_SUPPORT - Blocks are live if they reference live blocks.
  public static final /*uint32_t*/int S_ATTR_LIVE_SUPPORT = 0x08000000/*U*/;
  /// S_ATTR_SELF_MODIFYING_CODE - Used with i386 code stubs written on by
  /// dyld.
  public static final /*uint32_t*/int S_ATTR_SELF_MODIFYING_CODE = 0x04000000/*U*/;
  /// S_ATTR_DEBUG - A debug section.
  public static final /*uint32_t*/int S_ATTR_DEBUG = 0x02000000/*U*/;
  
  // Constant masks for the "flags[23:8]" field in llvm::MachO::section and
  // llvm::MachO::section_64 (mask "flags" with SECTION_ATTRIBUTES_SYS)
  
  /// S_ATTR_SOME_INSTRUCTIONS - Section contains some machine instructions.
  public static final /*uint32_t*/int S_ATTR_SOME_INSTRUCTIONS = 0x00000400/*U*/;
  /// S_ATTR_EXT_RELOC - Section has external relocation entries.
  public static final /*uint32_t*/int S_ATTR_EXT_RELOC = 0x00000200/*U*/;
  /// S_ATTR_LOC_RELOC - Section has local relocation entries.
  public static final /*uint32_t*/int S_ATTR_LOC_RELOC = 0x00000100/*U*/;
  
  // Constant masks for the value of an indirect symbol in an indirect
  // symbol table
  public static final /*uint32_t*/int INDIRECT_SYMBOL_LOCAL = 0x80000000/*U*/;
  public static final /*uint32_t*/int INDIRECT_SYMBOL_ABS = 0x40000000/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::DataRegionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 215,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 257,
 FQN="llvm::MachO::DataRegionType", NM="_ZN4llvm5MachO14DataRegionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14DataRegionTypeE")
//</editor-fold>
public enum DataRegionType implements Native.NativeUIntEnum {
  // Constants for the "kind" field in a data_in_code_entry structure
  DICE_KIND_DATA(1/*U*/),
  DICE_KIND_JUMP_TABLE8(2/*U*/),
  DICE_KIND_JUMP_TABLE16(3/*U*/),
  DICE_KIND_JUMP_TABLE32(4/*U*/),
  DICE_KIND_ABS_JUMP_TABLE32(5/*U*/);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static DataRegionType valueOf(int val) {
    DataRegionType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final DataRegionType[] VALUES;
    private static final DataRegionType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (DataRegionType kind : DataRegionType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new DataRegionType[min < 0 ? (1-min) : 0];
      VALUES = new DataRegionType[max >= 0 ? (1+max) : 0];
      for (DataRegionType kind : DataRegionType.values()) {
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

  private final /*uint*/int value;
  private DataRegionType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::RebaseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 224,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 266,
 FQN="llvm::MachO::RebaseType", NM="_ZN4llvm5MachO10RebaseTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10RebaseTypeE")
//</editor-fold>
public enum RebaseType implements Native.NativeUIntEnum {
  REBASE_TYPE_POINTER(1/*U*/),
  REBASE_TYPE_TEXT_ABSOLUTE32(2/*U*/),
  REBASE_TYPE_TEXT_PCREL32(3/*U*/);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RebaseType valueOf(int val) {
    RebaseType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RebaseType[] VALUES;
    private static final RebaseType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RebaseType kind : RebaseType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RebaseType[min < 0 ? (1-min) : 0];
      VALUES = new RebaseType[max >= 0 ? (1+max) : 0];
      for (RebaseType kind : RebaseType.values()) {
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

  private final /*uint*/int value;
  private RebaseType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 230,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 272,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum10",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum10")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int REBASE_OPCODE_MASK = 0xF0/*U*/;
  public static final /*uint*/int REBASE_IMMEDIATE_MASK = 0x0F/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::RebaseOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 235,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 277,
 FQN="llvm::MachO::RebaseOpcode", NM="_ZN4llvm5MachO12RebaseOpcodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO12RebaseOpcodeE")
//</editor-fold>
public static final class/*enum*/ RebaseOpcode {
  public static final /*uint*/int REBASE_OPCODE_DONE = 0x00/*U*/;
  public static final /*uint*/int REBASE_OPCODE_SET_TYPE_IMM = 0x10/*U*/;
  public static final /*uint*/int REBASE_OPCODE_SET_SEGMENT_AND_OFFSET_ULEB = 0x20/*U*/;
  public static final /*uint*/int REBASE_OPCODE_ADD_ADDR_ULEB = 0x30/*U*/;
  public static final /*uint*/int REBASE_OPCODE_ADD_ADDR_IMM_SCALED = 0x40/*U*/;
  public static final /*uint*/int REBASE_OPCODE_DO_REBASE_IMM_TIMES = 0x50/*U*/;
  public static final /*uint*/int REBASE_OPCODE_DO_REBASE_ULEB_TIMES = 0x60/*U*/;
  public static final /*uint*/int REBASE_OPCODE_DO_REBASE_ADD_ADDR_ULEB = 0x70/*U*/;
  public static final /*uint*/int REBASE_OPCODE_DO_REBASE_ULEB_TIMES_SKIPPING_ULEB = 0x80/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::BindType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 247,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 289,
 FQN="llvm::MachO::BindType", NM="_ZN4llvm5MachO8BindTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8BindTypeE")
//</editor-fold>
public enum BindType implements Native.NativeUIntEnum {
  BIND_TYPE_POINTER(1/*U*/),
  BIND_TYPE_TEXT_ABSOLUTE32(2/*U*/),
  BIND_TYPE_TEXT_PCREL32(3/*U*/);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static BindType valueOf(int val) {
    BindType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final BindType[] VALUES;
    private static final BindType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (BindType kind : BindType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new BindType[min < 0 ? (1-min) : 0];
      VALUES = new BindType[max >= 0 ? (1+max) : 0];
      for (BindType kind : BindType.values()) {
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

  private final /*uint*/int value;
  private BindType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::BindSpecialDylib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 253,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 295,
 FQN="llvm::MachO::BindSpecialDylib", NM="_ZN4llvm5MachO16BindSpecialDylibE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16BindSpecialDylibE")
//</editor-fold>
public enum BindSpecialDylib implements Native.NativeIntEnum {
  BIND_SPECIAL_DYLIB_SELF(0),
  BIND_SPECIAL_DYLIB_MAIN_EXECUTABLE(-1),
  BIND_SPECIAL_DYLIB_FLAT_LOOKUP(-2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static BindSpecialDylib valueOf(int val) {
    BindSpecialDylib out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final BindSpecialDylib[] VALUES;
    private static final BindSpecialDylib[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (BindSpecialDylib kind : BindSpecialDylib.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new BindSpecialDylib[min < 0 ? (1-min) : 0];
      VALUES = new BindSpecialDylib[max >= 0 ? (1+max) : 0];
      for (BindSpecialDylib kind : BindSpecialDylib.values()) {
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
  private BindSpecialDylib(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 259,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 301,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum14",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum14")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int BIND_SYMBOL_FLAGS_WEAK_IMPORT = 0x1/*U*/;
  public static final /*uint*/int BIND_SYMBOL_FLAGS_NON_WEAK_DEFINITION = 0x8/*U*/;
  
  public static final /*uint*/int BIND_OPCODE_MASK = 0xF0/*U*/;
  public static final /*uint*/int BIND_IMMEDIATE_MASK = 0x0F/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::BindOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 309,
 FQN="llvm::MachO::BindOpcode", NM="_ZN4llvm5MachO10BindOpcodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10BindOpcodeE")
//</editor-fold>
public static final class/*enum*/ BindOpcode {
  public static final /*uint*/int BIND_OPCODE_DONE = 0x00/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_DYLIB_ORDINAL_IMM = 0x10/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_DYLIB_ORDINAL_ULEB = 0x20/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_DYLIB_SPECIAL_IMM = 0x30/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_SYMBOL_TRAILING_FLAGS_IMM = 0x40/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_TYPE_IMM = 0x50/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_ADDEND_SLEB = 0x60/*U*/;
  public static final /*uint*/int BIND_OPCODE_SET_SEGMENT_AND_OFFSET_ULEB = 0x70/*U*/;
  public static final /*uint*/int BIND_OPCODE_ADD_ADDR_ULEB = 0x80/*U*/;
  public static final /*uint*/int BIND_OPCODE_DO_BIND = 0x90/*U*/;
  public static final /*uint*/int BIND_OPCODE_DO_BIND_ADD_ADDR_ULEB = 0xA0/*U*/;
  public static final /*uint*/int BIND_OPCODE_DO_BIND_ADD_ADDR_IMM_SCALED = 0xB0/*U*/;
  public static final /*uint*/int BIND_OPCODE_DO_BIND_ULEB_TIMES_SKIPPING_ULEB = 0xC0/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 283,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 325,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum16",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum16")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_KIND_MASK = 0x03/*U*/;
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_WEAK_DEFINITION = 0x04/*U*/;
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_REEXPORT = 0x08/*U*/;
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_STUB_AND_RESOLVER = 0x10/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::ExportSymbolKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 290,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 332,
 FQN="llvm::MachO::ExportSymbolKind", NM="_ZN4llvm5MachO16ExportSymbolKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16ExportSymbolKindE")
//</editor-fold>
public static final class/*enum*/ ExportSymbolKind {
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_KIND_REGULAR = 0x00/*U*/;
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_KIND_THREAD_LOCAL = 0x01/*U*/;
  public static final /*uint*/int EXPORT_SYMBOL_FLAGS_KIND_ABSOLUTE = 0x02/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 296,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 338,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum18",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum18")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // Constant masks for the "n_type" field in llvm::MachO::nlist and
  // llvm::MachO::nlist_64
  public static final /*uint*/int N_STAB = 0xe0;
  public static final /*uint*/int N_PEXT = 0x10;
  public static final /*uint*/int N_TYPE = 0x0e;
  public static final /*uint*/int N_EXT = 0x01;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::NListType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 305,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 347,
 FQN="llvm::MachO::NListType", NM="_ZN4llvm5MachO9NListTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO9NListTypeE")
//</editor-fold>
public static final class/*enum*/ NListType {
  // Constants for the "n_type & N_TYPE" llvm::MachO::nlist and
  // llvm::MachO::nlist_64
  public static final /*uint*/int N_UNDF = 0x0/*U*/;
  public static final /*uint*/int N_ABS = 0x2/*U*/;
  public static final /*uint*/int N_SECT = 0xe/*U*/;
  public static final /*uint*/int N_PBUD = 0xc/*U*/;
  public static final /*uint*/int N_INDR = 0xa/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::SectionOrdinal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 315,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 357,
 FQN="llvm::MachO::SectionOrdinal", NM="_ZN4llvm5MachO14SectionOrdinalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14SectionOrdinalE")
//</editor-fold>
public static final class/*enum*/ SectionOrdinal {
  // Constants for the "n_sect" field in llvm::MachO::nlist and
  // llvm::MachO::nlist_64
  public static final /*uint*/int NO_SECT = 0/*U*/;
  public static final /*uint*/int MAX_SECT = 0xff/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 322,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 364,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum21",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum21")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  // Constant masks for the "n_desc" field in llvm::MachO::nlist and
  // llvm::MachO::nlist_64
  // The low 3 bits are the for the REFERENCE_TYPE.
  public static final /*uint*/int REFERENCE_TYPE = 0x7;
  public static final /*uint*/int REFERENCE_FLAG_UNDEFINED_NON_LAZY = 0;
  public static final /*uint*/int REFERENCE_FLAG_UNDEFINED_LAZY = 1;
  public static final /*uint*/int REFERENCE_FLAG_DEFINED = 2;
  public static final /*uint*/int REFERENCE_FLAG_PRIVATE_DEFINED = 3;
  public static final /*uint*/int REFERENCE_FLAG_PRIVATE_UNDEFINED_NON_LAZY = 4;
  public static final /*uint*/int REFERENCE_FLAG_PRIVATE_UNDEFINED_LAZY = 5;
  // Flag bits (some overlap with the library ordinal bits).
  public static final /*uint*/int N_ARM_THUMB_DEF = 0x0008/*U*/;
  public static final /*uint*/int REFERENCED_DYNAMICALLY = 0x0010/*U*/;
  public static final /*uint*/int N_NO_DEAD_STRIP = 0x0020/*U*/;
  public static final /*uint*/int N_WEAK_REF = 0x0040/*U*/;
  public static final /*uint*/int N_WEAK_DEF = 0x0080/*U*/;
  public static final /*uint*/int N_SYMBOL_RESOLVER = 0x0100/*U*/;
  public static final /*uint*/int N_ALT_ENTRY = 0x0200/*U*/;
  // For undefined symbols coming from libraries, see GET_LIBRARY_ORDINAL()
  // as these are in the top 8 bits.
  public static final /*uint*/int SELF_LIBRARY_ORDINAL = 0x0;
  public static final /*uint*/int MAX_LIBRARY_ORDINAL = 0xfd;
  public static final /*uint*/int DYNAMIC_LOOKUP_ORDINAL = 0xfe;
  public static final /*uint*/int EXECUTABLE_ORDINAL = 0xff;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::StabType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 349,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 391,
 FQN="llvm::MachO::StabType", NM="_ZN4llvm5MachO8StabTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8StabTypeE")
//</editor-fold>
public static final class/*enum*/ StabType {
  // Constant values for the "n_type" field in llvm::MachO::nlist and
  // llvm::MachO::nlist_64 when "(n_type & N_STAB) != 0"
  public static final /*uint*/int N_GSYM = 0x20/*U*/;
  public static final /*uint*/int N_FNAME = 0x22/*U*/;
  public static final /*uint*/int N_FUN = 0x24/*U*/;
  public static final /*uint*/int N_STSYM = 0x26/*U*/;
  public static final /*uint*/int N_LCSYM = 0x28/*U*/;
  public static final /*uint*/int N_BNSYM = 0x2E/*U*/;
  public static final /*uint*/int N_PC = 0x30/*U*/;
  public static final /*uint*/int N_AST = 0x32/*U*/;
  public static final /*uint*/int N_OPT = 0x3C/*U*/;
  public static final /*uint*/int N_RSYM = 0x40/*U*/;
  public static final /*uint*/int N_SLINE = 0x44/*U*/;
  public static final /*uint*/int N_ENSYM = 0x4E/*U*/;
  public static final /*uint*/int N_SSYM = 0x60/*U*/;
  public static final /*uint*/int N_SO = 0x64/*U*/;
  public static final /*uint*/int N_OSO = 0x66/*U*/;
  public static final /*uint*/int N_LSYM = 0x80/*U*/;
  public static final /*uint*/int N_BINCL = 0x82/*U*/;
  public static final /*uint*/int N_SOL = 0x84/*U*/;
  public static final /*uint*/int N_PARAMS = 0x86/*U*/;
  public static final /*uint*/int N_VERSION = 0x88/*U*/;
  public static final /*uint*/int N_OLEVEL = 0x8A/*U*/;
  public static final /*uint*/int N_PSYM = 0xA0/*U*/;
  public static final /*uint*/int N_EINCL = 0xA2/*U*/;
  public static final /*uint*/int N_ENTRY = 0xA4/*U*/;
  public static final /*uint*/int N_LBRAC = 0xC0/*U*/;
  public static final /*uint*/int N_EXCL = 0xC2/*U*/;
  public static final /*uint*/int N_RBRAC = 0xE0/*U*/;
  public static final /*uint*/int N_BCOMM = 0xE2/*U*/;
  public static final /*uint*/int N_ECOMM = 0xE4/*U*/;
  public static final /*uint*/int N_ECOML = 0xE8/*U*/;
  public static final /*uint*/int N_LENG = 0xFE/*U*/;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 385,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 427,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum23",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum23")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Constant values for the r_symbolnum field in an
  // llvm::MachO::relocation_info structure when r_extern is 0.
  public static final /*uint32_t*/int R_ABS = 0;
  
  // Constant bits for the r_address field in an
  // llvm::MachO::relocation_info structure.
  public static final /*uint32_t*/int R_SCATTERED = 0x80000000/*U*/;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::RelocationInfoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 395,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 437,
 FQN="llvm::MachO::RelocationInfoType", NM="_ZN4llvm5MachO18RelocationInfoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18RelocationInfoTypeE")
//</editor-fold>
public enum RelocationInfoType implements Native.NativeUIntEnum {
  // Constant values for the r_type field in an
  // llvm::MachO::relocation_info or llvm::MachO::scattered_relocation_info
  // structure.
  GENERIC_RELOC_VANILLA(0),
  GENERIC_RELOC_PAIR(1),
  GENERIC_RELOC_SECTDIFF(2),
  GENERIC_RELOC_PB_LA_PTR(3),
  GENERIC_RELOC_LOCAL_SECTDIFF(4),
  GENERIC_RELOC_TLV(5),
  
  // Constant values for the r_type field in a PowerPC architecture
  // llvm::MachO::relocation_info or llvm::MachO::scattered_relocation_info
  // structure.
  PPC_RELOC_VANILLA(RelocationInfoType.GENERIC_RELOC_VANILLA.getValue()),
  PPC_RELOC_PAIR(RelocationInfoType.GENERIC_RELOC_PAIR.getValue()),
  PPC_RELOC_BR14(2),
  PPC_RELOC_BR24(3),
  PPC_RELOC_HI16(4),
  PPC_RELOC_LO16(5),
  PPC_RELOC_HA16(6),
  PPC_RELOC_LO14(7),
  PPC_RELOC_SECTDIFF(8),
  PPC_RELOC_PB_LA_PTR(9),
  PPC_RELOC_HI16_SECTDIFF(10),
  PPC_RELOC_LO16_SECTDIFF(11),
  PPC_RELOC_HA16_SECTDIFF(12),
  PPC_RELOC_JBSR(13),
  PPC_RELOC_LO14_SECTDIFF(14),
  PPC_RELOC_LOCAL_SECTDIFF(15),
  
  // Constant values for the r_type field in an ARM architecture
  // llvm::MachO::relocation_info or llvm::MachO::scattered_relocation_info
  // structure.
  ARM_RELOC_VANILLA(RelocationInfoType.GENERIC_RELOC_VANILLA.getValue()),
  ARM_RELOC_PAIR(RelocationInfoType.GENERIC_RELOC_PAIR.getValue()),
  ARM_RELOC_SECTDIFF(RelocationInfoType.GENERIC_RELOC_SECTDIFF.getValue()),
  ARM_RELOC_LOCAL_SECTDIFF(3),
  ARM_RELOC_PB_LA_PTR(4),
  ARM_RELOC_BR24(5),
  ARM_THUMB_RELOC_BR22(6),
  ARM_THUMB_32BIT_BRANCH(7), // obsolete
  ARM_RELOC_HALF(8),
  ARM_RELOC_HALF_SECTDIFF(9),
  
  // Constant values for the r_type field in an ARM64 architecture
  // llvm::MachO::relocation_info or llvm::MachO::scattered_relocation_info
  // structure.
  
  // For pointers.
  ARM64_RELOC_UNSIGNED(0),
  // Must be followed by an ARM64_RELOC_UNSIGNED
  ARM64_RELOC_SUBTRACTOR(1),
  // A B/BL instruction with 26-bit displacement.
  ARM64_RELOC_BRANCH26(2),
  // PC-rel distance to page of target.
  ARM64_RELOC_PAGE21(3),
  // Offset within page, scaled by r_length.
  ARM64_RELOC_PAGEOFF12(4),
  // PC-rel distance to page of GOT slot.
  ARM64_RELOC_GOT_LOAD_PAGE21(5),
  // Offset within page of GOT slot, scaled by r_length.
  ARM64_RELOC_GOT_LOAD_PAGEOFF12(6),
  // For pointers to GOT slots.
  ARM64_RELOC_POINTER_TO_GOT(7),
  // PC-rel distance to page of TLVP slot.
  ARM64_RELOC_TLVP_LOAD_PAGE21(8),
  // Offset within page of TLVP slot, scaled by r_length.
  ARM64_RELOC_TLVP_LOAD_PAGEOFF12(9),
  // Must be followed by ARM64_RELOC_PAGE21 or ARM64_RELOC_PAGEOFF12.
  ARM64_RELOC_ADDEND(10),
  
  // Constant values for the r_type field in an x86_64 architecture
  // llvm::MachO::relocation_info or llvm::MachO::scattered_relocation_info
  // structure
  X86_64_RELOC_UNSIGNED(0),
  X86_64_RELOC_SIGNED(1),
  X86_64_RELOC_BRANCH(2),
  X86_64_RELOC_GOT_LOAD(3),
  X86_64_RELOC_GOT(4),
  X86_64_RELOC_SUBTRACTOR(5),
  X86_64_RELOC_SIGNED_1(6),
  X86_64_RELOC_SIGNED_2(7),
  X86_64_RELOC_SIGNED_4(8),
  X86_64_RELOC_TLV(9);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RelocationInfoType valueOf(int val) {
    RelocationInfoType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RelocationInfoType[] VALUES;
    private static final RelocationInfoType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RelocationInfoType kind : RelocationInfoType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RelocationInfoType[min < 0 ? (1-min) : 0];
      VALUES = new RelocationInfoType[max >= 0 ? (1+max) : 0];
      for (RelocationInfoType kind : RelocationInfoType.values()) {
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

  private final /*uint*/int value;
  private RelocationInfoType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

// Values for segment_command.initprot.
// From <mach/vm_prot.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 484,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 526,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum25",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum25")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int VM_PROT_READ = 0x1;
  public static final /*uint*/int VM_PROT_WRITE = 0x2;
  public static final /*uint*/int VM_PROT_EXECUTE = 0x4;
/*}*/

// Structs from <mach-o/loader.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::mach_header">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 492,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 534,
 FQN="llvm::MachO::mach_header", NM="_ZN4llvm5MachO11mach_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11mach_headerE")
//</editor-fold>
public static class/*struct*/ mach_header {
  public /*uint32_t*/int magic;
  public /*uint32_t*/int cputype;
  public /*uint32_t*/int cpusubtype;
  public /*uint32_t*/int filetype;
  public /*uint32_t*/int ncmds;
  public /*uint32_t*/int sizeofcmds;
  public /*uint32_t*/int flags;
  
  public static int $sizeof_Mach_header() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "magic=" + magic // NOI18N
              + ", cputype=" + cputype // NOI18N
              + ", cpusubtype=" + cpusubtype // NOI18N
              + ", filetype=" + filetype // NOI18N
              + ", ncmds=" + ncmds // NOI18N
              + ", sizeofcmds=" + sizeofcmds // NOI18N
              + ", flags=" + flags; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::mach_header_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 502,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 544,
 FQN="llvm::MachO::mach_header_64", NM="_ZN4llvm5MachO14mach_header_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14mach_header_64E")
//</editor-fold>
public static class/*struct*/ mach_header_64 {
  public /*uint32_t*/int magic;
  public /*uint32_t*/int cputype;
  public /*uint32_t*/int cpusubtype;
  public /*uint32_t*/int filetype;
  public /*uint32_t*/int ncmds;
  public /*uint32_t*/int sizeofcmds;
  public /*uint32_t*/int flags;
  public /*uint32_t*/int reserved;
  
  public static int $sizeof_Mach_header_64() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override public String toString() {
    return "" + "magic=" + magic // NOI18N
              + ", cputype=" + cputype // NOI18N
              + ", cpusubtype=" + cpusubtype // NOI18N
              + ", filetype=" + filetype // NOI18N
              + ", ncmds=" + ncmds // NOI18N
              + ", sizeofcmds=" + sizeofcmds // NOI18N
              + ", flags=" + flags // NOI18N
              + ", reserved=" + reserved; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::load_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 513,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 555,
 FQN="llvm::MachO::load_command", NM="_ZN4llvm5MachO12load_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO12load_commandE")
//</editor-fold>
public static class/*struct*/ load_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::segment_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 518,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 560,
 FQN="llvm::MachO::segment_command", NM="_ZN4llvm5MachO15segment_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15segment_commandE")
//</editor-fold>
public static class/*struct*/ segment_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*char*/byte segname[/*16*/] = new$char(16);
  public /*uint32_t*/int vmaddr;
  public /*uint32_t*/int vmsize;
  public /*uint32_t*/int fileoff;
  public /*uint32_t*/int filesize;
  public /*uint32_t*/int maxprot;
  public /*uint32_t*/int initprot;
  public /*uint32_t*/int nsects;
  public /*uint32_t*/int flags;
  
  public static int $sizeof_Segment_command() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
    
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", segname=" + segname // NOI18N
              + ", vmaddr=" + vmaddr // NOI18N
              + ", vmsize=" + vmsize // NOI18N
              + ", fileoff=" + fileoff // NOI18N
              + ", filesize=" + filesize // NOI18N
              + ", maxprot=" + maxprot // NOI18N
              + ", initprot=" + initprot // NOI18N
              + ", nsects=" + nsects // NOI18N
              + ", flags=" + flags; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::segment_command_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 532,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 574,
 FQN="llvm::MachO::segment_command_64", NM="_ZN4llvm5MachO18segment_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18segment_command_64E")
//</editor-fold>
public static class/*struct*/ segment_command_64 {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*char*/byte segname[/*16*/] = new$char(16);
  public long/*uint64_t*/ vmaddr;
  public long/*uint64_t*/ vmsize;
  public long/*uint64_t*/ fileoff;
  public long/*uint64_t*/ filesize;
  public /*uint32_t*/int maxprot;
  public /*uint32_t*/int initprot;
  public /*uint32_t*/int nsects;
  public /*uint32_t*/int flags;

  public static int $sizeof_Segment_command_64() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", segname=" + segname // NOI18N
              + ", vmaddr=" + vmaddr // NOI18N
              + ", vmsize=" + vmsize // NOI18N
              + ", fileoff=" + fileoff // NOI18N
              + ", filesize=" + filesize // NOI18N
              + ", maxprot=" + maxprot // NOI18N
              + ", initprot=" + initprot // NOI18N
              + ", nsects=" + nsects // NOI18N
              + ", flags=" + flags; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::section">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 546,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 588,
 FQN="llvm::MachO::section", NM="_ZN4llvm5MachO7sectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO7sectionE")
//</editor-fold>
public static class/*struct*/ section {
  public /*char*/byte sectname[/*16*/] = new$char(16);
  public /*char*/byte segname[/*16*/] = new$char(16);
  public /*uint32_t*/int addr;
  public /*uint32_t*/int size;
  public /*uint32_t*/int offset;
  public /*uint32_t*/int align;
  public /*uint32_t*/int reloff;
  public /*uint32_t*/int nreloc;
  public /*uint32_t*/int flags;
  public /*uint32_t*/int reserved1;
  public /*uint32_t*/int reserved2;
  
  public static int $sizeof_Section() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override public String toString() {
    return "" + "sectname=" + sectname // NOI18N
              + ", segname=" + segname // NOI18N
              + ", addr=" + addr // NOI18N
              + ", size=" + size // NOI18N
              + ", offset=" + offset // NOI18N
              + ", align=" + align // NOI18N
              + ", reloff=" + reloff // NOI18N
              + ", nreloc=" + nreloc // NOI18N
              + ", flags=" + flags // NOI18N
              + ", reserved1=" + reserved1 // NOI18N
              + ", reserved2=" + reserved2; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::section_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 560,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 602,
 FQN="llvm::MachO::section_64", NM="_ZN4llvm5MachO10section_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10section_64E")
//</editor-fold>
public static class/*struct*/ section_64 {
  public /*char*/byte sectname[/*16*/] = new$char(16);
  public /*char*/byte segname[/*16*/] = new$char(16);
  public long/*uint64_t*/ addr;
  public long/*uint64_t*/ size;
  public /*uint32_t*/int offset;
  public /*uint32_t*/int align;
  public /*uint32_t*/int reloff;
  public /*uint32_t*/int nreloc;
  public /*uint32_t*/int flags;
  public /*uint32_t*/int reserved1;
  public /*uint32_t*/int reserved2;
  public /*uint32_t*/int reserved3;
  
  public static int $sizeof_Section_64() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

    @Override public String toString() {
    return "" + "sectname=" + sectname // NOI18N
              + ", segname=" + segname // NOI18N
              + ", addr=" + addr // NOI18N
              + ", size=" + size // NOI18N
              + ", offset=" + offset // NOI18N
              + ", align=" + align // NOI18N
              + ", reloff=" + reloff // NOI18N
              + ", nreloc=" + nreloc // NOI18N
              + ", flags=" + flags // NOI18N
              + ", reserved1=" + reserved1 // NOI18N
              + ", reserved2=" + reserved2 // NOI18N
              + ", reserved3=" + reserved3; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fvmlib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 575,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 617,
 FQN="llvm::MachO::fvmlib", NM="_ZN4llvm5MachO6fvmlibE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO6fvmlibE")
//</editor-fold>
public static class/*struct*/ fvmlib {
  public /*uint32_t*/int name;
  public /*uint32_t*/int minor_version;
  public /*uint32_t*/int header_addr;
  
  @Override public String toString() {
    return "" + "name=" + name // NOI18N
              + ", minor_version=" + minor_version // NOI18N
              + ", header_addr=" + header_addr; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fvmlib_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 581,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 623,
 FQN="llvm::MachO::fvmlib_command", NM="_ZN4llvm5MachO14fvmlib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14fvmlib_commandE")
//</editor-fold>
public static class/*struct*/ fvmlib_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public  fvmlib fvmlib;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", fvmlib=" + fvmlib; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 587,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 629,
 FQN="llvm::MachO::dylib", NM="_ZN4llvm5MachO5dylibE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO5dylibE")
//</editor-fold>
public static class/*struct*/ dylib {
  public /*uint32_t*/int name;
  public /*uint32_t*/int timestamp;
  public /*uint32_t*/int current_version;
  public /*uint32_t*/int compatibility_version;
  
  @Override public String toString() {
    return "" + "name=" + name // NOI18N
              + ", timestamp=" + timestamp // NOI18N
              + ", current_version=" + current_version // NOI18N
              + ", compatibility_version=" + compatibility_version; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 594,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 636,
 FQN="llvm::MachO::dylib_command", NM="_ZN4llvm5MachO13dylib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13dylib_commandE")
//</editor-fold>
public static class/*struct*/ dylib_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public  dylib dylib;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", dylib=" + dylib; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::sub_framework_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 600,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 642,
 FQN="llvm::MachO::sub_framework_command", NM="_ZN4llvm5MachO21sub_framework_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21sub_framework_commandE")
//</editor-fold>
public static class/*struct*/ sub_framework_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int umbrella;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", umbrella=" + umbrella; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::sub_client_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 606,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 648,
 FQN="llvm::MachO::sub_client_command", NM="_ZN4llvm5MachO18sub_client_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18sub_client_commandE")
//</editor-fold>
public static class/*struct*/ sub_client_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int client;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", client=" + client; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::sub_umbrella_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 612,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 654,
 FQN="llvm::MachO::sub_umbrella_command", NM="_ZN4llvm5MachO20sub_umbrella_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO20sub_umbrella_commandE")
//</editor-fold>
public static class/*struct*/ sub_umbrella_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int sub_umbrella;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", sub_umbrella=" + sub_umbrella; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::sub_library_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 618,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 660,
 FQN="llvm::MachO::sub_library_command", NM="_ZN4llvm5MachO19sub_library_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19sub_library_commandE")
//</editor-fold>
public static class/*struct*/ sub_library_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int sub_library;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", sub_library=" + sub_library; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::prebound_dylib_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 624,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 666,
 FQN="llvm::MachO::prebound_dylib_command", NM="_ZN4llvm5MachO22prebound_dylib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO22prebound_dylib_commandE")
//</editor-fold>
public static class/*struct*/ prebound_dylib_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int name;
  public /*uint32_t*/int nmodules;
  public /*uint32_t*/int linked_modules;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", name=" + name // NOI18N
              + ", nmodules=" + nmodules // NOI18N
              + ", linked_modules=" + linked_modules; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylinker_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 632,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 674,
 FQN="llvm::MachO::dylinker_command", NM="_ZN4llvm5MachO16dylinker_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16dylinker_commandE")
//</editor-fold>
public static class/*struct*/ dylinker_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int name;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", name=" + name; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::thread_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 638,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 680,
 FQN="llvm::MachO::thread_command", NM="_ZN4llvm5MachO14thread_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14thread_commandE")
//</editor-fold>
public static class/*struct*/ thread_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::routines_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 643,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 685,
 FQN="llvm::MachO::routines_command", NM="_ZN4llvm5MachO16routines_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16routines_commandE")
//</editor-fold>
public static class/*struct*/ routines_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int init_address;
  public /*uint32_t*/int init_module;
  public /*uint32_t*/int reserved1;
  public /*uint32_t*/int reserved2;
  public /*uint32_t*/int reserved3;
  public /*uint32_t*/int reserved4;
  public /*uint32_t*/int reserved5;
  public /*uint32_t*/int reserved6;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", init_address=" + init_address // NOI18N
              + ", init_module=" + init_module // NOI18N
              + ", reserved1=" + reserved1 // NOI18N
              + ", reserved2=" + reserved2 // NOI18N
              + ", reserved3=" + reserved3 // NOI18N
              + ", reserved4=" + reserved4 // NOI18N
              + ", reserved5=" + reserved5 // NOI18N
              + ", reserved6=" + reserved6; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::routines_command_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 656,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 698,
 FQN="llvm::MachO::routines_command_64", NM="_ZN4llvm5MachO19routines_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19routines_command_64E")
//</editor-fold>
public static class/*struct*/ routines_command_64 {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public long/*uint64_t*/ init_address;
  public long/*uint64_t*/ init_module;
  public long/*uint64_t*/ reserved1;
  public long/*uint64_t*/ reserved2;
  public long/*uint64_t*/ reserved3;
  public long/*uint64_t*/ reserved4;
  public long/*uint64_t*/ reserved5;
  public long/*uint64_t*/ reserved6;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", init_address=" + init_address // NOI18N
              + ", init_module=" + init_module // NOI18N
              + ", reserved1=" + reserved1 // NOI18N
              + ", reserved2=" + reserved2 // NOI18N
              + ", reserved3=" + reserved3 // NOI18N
              + ", reserved4=" + reserved4 // NOI18N
              + ", reserved5=" + reserved5 // NOI18N
              + ", reserved6=" + reserved6; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::symtab_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 669,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 711,
 FQN="llvm::MachO::symtab_command", NM="_ZN4llvm5MachO14symtab_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14symtab_commandE")
//</editor-fold>
public static class/*struct*/ symtab_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int symoff;
  public /*uint32_t*/int nsyms;
  public /*uint32_t*/int stroff;
  public /*uint32_t*/int strsize;
  
  public static int $sizeof_Symtab_command() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", symoff=" + symoff // NOI18N
              + ", nsyms=" + nsyms // NOI18N
              + ", stroff=" + stroff // NOI18N
              + ", strsize=" + strsize; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dysymtab_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 678,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 720,
 FQN="llvm::MachO::dysymtab_command", NM="_ZN4llvm5MachO16dysymtab_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16dysymtab_commandE")
//</editor-fold>
public static class/*struct*/ dysymtab_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int ilocalsym;
  public /*uint32_t*/int nlocalsym;
  public /*uint32_t*/int iextdefsym;
  public /*uint32_t*/int nextdefsym;
  public /*uint32_t*/int iundefsym;
  public /*uint32_t*/int nundefsym;
  public /*uint32_t*/int tocoff;
  public /*uint32_t*/int ntoc;
  public /*uint32_t*/int modtaboff;
  public /*uint32_t*/int nmodtab;
  public /*uint32_t*/int extrefsymoff;
  public /*uint32_t*/int nextrefsyms;
  public /*uint32_t*/int indirectsymoff;
  public /*uint32_t*/int nindirectsyms;
  public /*uint32_t*/int extreloff;
  public /*uint32_t*/int nextrel;
  public /*uint32_t*/int locreloff;
  public /*uint32_t*/int nlocrel;

  public static int $sizeof_Dysymtab_command() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", ilocalsym=" + ilocalsym // NOI18N
              + ", nlocalsym=" + nlocalsym // NOI18N
              + ", iextdefsym=" + iextdefsym // NOI18N
              + ", nextdefsym=" + nextdefsym // NOI18N
              + ", iundefsym=" + iundefsym // NOI18N
              + ", nundefsym=" + nundefsym // NOI18N
              + ", tocoff=" + tocoff // NOI18N
              + ", ntoc=" + ntoc // NOI18N
              + ", modtaboff=" + modtaboff // NOI18N
              + ", nmodtab=" + nmodtab // NOI18N
              + ", extrefsymoff=" + extrefsymoff // NOI18N
              + ", nextrefsyms=" + nextrefsyms // NOI18N
              + ", indirectsymoff=" + indirectsymoff // NOI18N
              + ", nindirectsyms=" + nindirectsyms // NOI18N
              + ", extreloff=" + extreloff // NOI18N
              + ", nextrel=" + nextrel // NOI18N
              + ", locreloff=" + locreloff // NOI18N
              + ", nlocrel=" + nlocrel; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib_table_of_contents">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 701,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 743,
 FQN="llvm::MachO::dylib_table_of_contents", NM="_ZN4llvm5MachO23dylib_table_of_contentsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO23dylib_table_of_contentsE")
//</editor-fold>
public static class/*struct*/ dylib_table_of_contents {
  public /*uint32_t*/int symbol_index;
  public /*uint32_t*/int module_index;
  
  @Override public String toString() {
    return "" + "symbol_index=" + symbol_index // NOI18N
              + ", module_index=" + module_index; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib_module">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 706,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 748,
 FQN="llvm::MachO::dylib_module", NM="_ZN4llvm5MachO12dylib_moduleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO12dylib_moduleE")
//</editor-fold>
public static class/*struct*/ dylib_module {
  public /*uint32_t*/int module_name;
  public /*uint32_t*/int iextdefsym;
  public /*uint32_t*/int nextdefsym;
  public /*uint32_t*/int irefsym;
  public /*uint32_t*/int nrefsym;
  public /*uint32_t*/int ilocalsym;
  public /*uint32_t*/int nlocalsym;
  public /*uint32_t*/int iextrel;
  public /*uint32_t*/int nextrel;
  public /*uint32_t*/int iinit_iterm;
  public /*uint32_t*/int ninit_nterm;
  public /*uint32_t*/int objc_module_info_addr;
  public /*uint32_t*/int objc_module_info_size;
  
  @Override public String toString() {
    return "" + "module_name=" + module_name // NOI18N
              + ", iextdefsym=" + iextdefsym // NOI18N
              + ", nextdefsym=" + nextdefsym // NOI18N
              + ", irefsym=" + irefsym // NOI18N
              + ", nrefsym=" + nrefsym // NOI18N
              + ", ilocalsym=" + ilocalsym // NOI18N
              + ", nlocalsym=" + nlocalsym // NOI18N
              + ", iextrel=" + iextrel // NOI18N
              + ", nextrel=" + nextrel // NOI18N
              + ", iinit_iterm=" + iinit_iterm // NOI18N
              + ", ninit_nterm=" + ninit_nterm // NOI18N
              + ", objc_module_info_addr=" + objc_module_info_addr // NOI18N
              + ", objc_module_info_size=" + objc_module_info_size; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib_module_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 722,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 764,
 FQN="llvm::MachO::dylib_module_64", NM="_ZN4llvm5MachO15dylib_module_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15dylib_module_64E")
//</editor-fold>
public static class/*struct*/ dylib_module_64 {
  public /*uint32_t*/int module_name;
  public /*uint32_t*/int iextdefsym;
  public /*uint32_t*/int nextdefsym;
  public /*uint32_t*/int irefsym;
  public /*uint32_t*/int nrefsym;
  public /*uint32_t*/int ilocalsym;
  public /*uint32_t*/int nlocalsym;
  public /*uint32_t*/int iextrel;
  public /*uint32_t*/int nextrel;
  public /*uint32_t*/int iinit_iterm;
  public /*uint32_t*/int ninit_nterm;
  public /*uint32_t*/int objc_module_info_size;
  public long/*uint64_t*/ objc_module_info_addr;
  
  @Override public String toString() {
    return "" + "module_name=" + module_name // NOI18N
              + ", iextdefsym=" + iextdefsym // NOI18N
              + ", nextdefsym=" + nextdefsym // NOI18N
              + ", irefsym=" + irefsym // NOI18N
              + ", nrefsym=" + nrefsym // NOI18N
              + ", ilocalsym=" + ilocalsym // NOI18N
              + ", nlocalsym=" + nlocalsym // NOI18N
              + ", iextrel=" + iextrel // NOI18N
              + ", nextrel=" + nextrel // NOI18N
              + ", iinit_iterm=" + iinit_iterm // NOI18N
              + ", ninit_nterm=" + ninit_nterm // NOI18N
              + ", objc_module_info_size=" + objc_module_info_size // NOI18N
              + ", objc_module_info_addr=" + objc_module_info_addr; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dylib_reference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 738,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 780,
 FQN="llvm::MachO::dylib_reference", NM="_ZN4llvm5MachO15dylib_referenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15dylib_referenceE")
//</editor-fold>
public static class/*struct*/ dylib_reference {
  public /*uint32_t*/int isym /*: 24*/;
  public /*JBYTE uint32_t*/ byte flags /*: 8*/;
  
  @Override public String toString() {
    return "" + "isym=" + isym // NOI18N
              + ", flags=" + $uchar2uint(flags); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::twolevel_hints_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 743,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 785,
 FQN="llvm::MachO::twolevel_hints_command", NM="_ZN4llvm5MachO22twolevel_hints_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO22twolevel_hints_commandE")
//</editor-fold>
public static class/*struct*/ twolevel_hints_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int offset;
  public /*uint32_t*/int nhints;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", offset=" + offset // NOI18N
              + ", nhints=" + nhints; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::twolevel_hint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 750,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 792,
 FQN="llvm::MachO::twolevel_hint", NM="_ZN4llvm5MachO13twolevel_hintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13twolevel_hintE")
//</editor-fold>
public static class/*struct*/ twolevel_hint {
  public /*JBYTE uint32_t*/ byte isub_image /*: 8*/;
  public /*uint32_t*/int itoc /*: 24*/;
  
  @Override public String toString() {
    return "" + "isub_image=" + $uchar2uint(isub_image) // NOI18N
              + ", itoc=" + itoc; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::prebind_cksum_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 755,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 797,
 FQN="llvm::MachO::prebind_cksum_command", NM="_ZN4llvm5MachO21prebind_cksum_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21prebind_cksum_commandE")
//</editor-fold>
public static class/*struct*/ prebind_cksum_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int cksum;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", cksum=" + cksum; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::uuid_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 761,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 803,
 FQN="llvm::MachO::uuid_command", NM="_ZN4llvm5MachO12uuid_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO12uuid_commandE")
//</editor-fold>
public static class/*struct*/ uuid_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public byte/*uint8_t*/ uuid[/*16*/] = new$char(16);
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", uuid=" + uuid; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::rpath_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 767,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 809,
 FQN="llvm::MachO::rpath_command", NM="_ZN4llvm5MachO13rpath_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13rpath_commandE")
//</editor-fold>
public static class/*struct*/ rpath_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int _path;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", _path=" + _path; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::linkedit_data_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 773,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 815,
 FQN="llvm::MachO::linkedit_data_command", NM="_ZN4llvm5MachO21linkedit_data_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21linkedit_data_commandE")
//</editor-fold>
public static class/*struct*/ linkedit_data_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int dataoff;
  public /*uint32_t*/int datasize;

  public static int $sizeof_Linkedit_data_command() {
    return 8;
  }
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", dataoff=" + dataoff // NOI18N
              + ", datasize=" + datasize; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::data_in_code_entry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 780,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 822,
 FQN="llvm::MachO::data_in_code_entry", NM="_ZN4llvm5MachO18data_in_code_entryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18data_in_code_entryE")
//</editor-fold>
public static class/*struct*/ data_in_code_entry {
  public /*uint32_t*/int offset;
  public /*uint16_t*/char length;
  public /*uint16_t*/char kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::data_in_code_entry::data_in_code_entry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 780,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 822,
   FQN="llvm::MachO::data_in_code_entry::data_in_code_entry", NM="_ZN4llvm5MachO18data_in_code_entryC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18data_in_code_entryC1EOS1_")
  //</editor-fold>
  public /*inline*/ data_in_code_entry(JD$Move _dparam, final data_in_code_entry /*&&*/$Prm0) {
    // : offset(static_cast<data_in_code_entry &&>().offset), length(static_cast<data_in_code_entry &&>().length), kind(static_cast<data_in_code_entry &&>().kind) 
    //START JInit
    this.offset = $Prm0.offset;
    this.length = $Prm0.length;
    this.kind = $Prm0.kind;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "offset=" + offset // NOI18N
              + ", length=" + $ushort2uint(length) // NOI18N
              + ", kind=" + $ushort2uint(kind); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::source_version_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 786,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 828,
 FQN="llvm::MachO::source_version_command", NM="_ZN4llvm5MachO22source_version_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO22source_version_commandE")
//</editor-fold>
public static class/*struct*/ source_version_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public long/*uint64_t*/ version;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", version=" + version; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::encryption_info_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 792,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 834,
 FQN="llvm::MachO::encryption_info_command", NM="_ZN4llvm5MachO23encryption_info_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO23encryption_info_commandE")
//</editor-fold>
public static class/*struct*/ encryption_info_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int cryptoff;
  public /*uint32_t*/int cryptsize;
  public /*uint32_t*/int cryptid;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", cryptoff=" + cryptoff // NOI18N
              + ", cryptsize=" + cryptsize // NOI18N
              + ", cryptid=" + cryptid; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::encryption_info_command_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 800,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 842,
 FQN="llvm::MachO::encryption_info_command_64", NM="_ZN4llvm5MachO26encryption_info_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO26encryption_info_command_64E")
//</editor-fold>
public static class/*struct*/ encryption_info_command_64 {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int cryptoff;
  public /*uint32_t*/int cryptsize;
  public /*uint32_t*/int cryptid;
  public /*uint32_t*/int pad;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", cryptoff=" + cryptoff // NOI18N
              + ", cryptsize=" + cryptsize // NOI18N
              + ", cryptid=" + cryptid // NOI18N
              + ", pad=" + pad; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::version_min_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 809,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 851,
 FQN="llvm::MachO::version_min_command", NM="_ZN4llvm5MachO19version_min_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19version_min_commandE")
//</editor-fold>
public static class/*struct*/ version_min_command {
  public /*uint32_t*/int cmd; // LC_VERSION_MIN_MACOSX or
  // LC_VERSION_MIN_IPHONEOS
  public /*uint32_t*/int cmdsize; // sizeof(struct version_min_command)
  public /*uint32_t*/int version; // X.Y.Z is encoded in nibbles xxxx.yy.zz
  public /*uint32_t*/int sdk; // X.Y.Z is encoded in nibbles xxxx.yy.zz

  public static int $sizeof_Version_min_command() {
    return 16;
  }
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", version=" + version // NOI18N
              + ", sdk=" + sdk; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::dyld_info_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 817,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 859,
 FQN="llvm::MachO::dyld_info_command", NM="_ZN4llvm5MachO17dyld_info_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17dyld_info_commandE")
//</editor-fold>
public static class/*struct*/ dyld_info_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int rebase_off;
  public /*uint32_t*/int rebase_size;
  public /*uint32_t*/int bind_off;
  public /*uint32_t*/int bind_size;
  public /*uint32_t*/int weak_bind_off;
  public /*uint32_t*/int weak_bind_size;
  public /*uint32_t*/int lazy_bind_off;
  public /*uint32_t*/int lazy_bind_size;
  public /*uint32_t*/int export_off;
  public /*uint32_t*/int export_size;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", rebase_off=" + rebase_off // NOI18N
              + ", rebase_size=" + rebase_size // NOI18N
              + ", bind_off=" + bind_off // NOI18N
              + ", bind_size=" + bind_size // NOI18N
              + ", weak_bind_off=" + weak_bind_off // NOI18N
              + ", weak_bind_size=" + weak_bind_size // NOI18N
              + ", lazy_bind_off=" + lazy_bind_off // NOI18N
              + ", lazy_bind_size=" + lazy_bind_size // NOI18N
              + ", export_off=" + export_off // NOI18N
              + ", export_size=" + export_size; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::linker_option_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 832,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 874,
 FQN="llvm::MachO::linker_option_command", NM="_ZN4llvm5MachO21linker_option_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21linker_option_commandE")
//</editor-fold>
public static class/*struct*/ linker_option_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int count;
  
  public static final int $sizeof_Linker_option_command(){
    return 12;
  }
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", count=" + count; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::symseg_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 838,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 880,
 FQN="llvm::MachO::symseg_command", NM="_ZN4llvm5MachO14symseg_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14symseg_commandE")
//</editor-fold>
public static class/*struct*/ symseg_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int offset;
  public /*uint32_t*/int size;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", offset=" + offset // NOI18N
              + ", size=" + size; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::ident_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 845,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 887,
 FQN="llvm::MachO::ident_command", NM="_ZN4llvm5MachO13ident_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13ident_commandE")
//</editor-fold>
public static class/*struct*/ ident_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fvmfile_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 850,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 892,
 FQN="llvm::MachO::fvmfile_command", NM="_ZN4llvm5MachO15fvmfile_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15fvmfile_commandE")
//</editor-fold>
public static class/*struct*/ fvmfile_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public /*uint32_t*/int name;
  public /*uint32_t*/int header_addr;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", name=" + name // NOI18N
              + ", header_addr=" + header_addr; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::tlv_descriptor_32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 857,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 899,
 FQN="llvm::MachO::tlv_descriptor_32", NM="_ZN4llvm5MachO17tlv_descriptor_32E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17tlv_descriptor_32E")
//</editor-fold>
public static class/*struct*/ tlv_descriptor_32 {
  public /*uint32_t*/int thunk;
  public /*uint32_t*/int key;
  public /*uint32_t*/int offset;
  
  @Override public String toString() {
    return "" + "thunk=" + thunk // NOI18N
              + ", key=" + key // NOI18N
              + ", offset=" + offset; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::tlv_descriptor_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 863,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 905,
 FQN="llvm::MachO::tlv_descriptor_64", NM="_ZN4llvm5MachO17tlv_descriptor_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17tlv_descriptor_64E")
//</editor-fold>
public static class/*struct*/ tlv_descriptor_64 {
  public long/*uint64_t*/ thunk;
  public long/*uint64_t*/ key;
  public long/*uint64_t*/ offset;
  
  @Override public String toString() {
    return "" + "thunk=" + thunk // NOI18N
              + ", key=" + key // NOI18N
              + ", offset=" + offset; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::tlv_descriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 869,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 911,
 FQN="llvm::MachO::tlv_descriptor", NM="_ZN4llvm5MachO14tlv_descriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO14tlv_descriptorE")
//</editor-fold>
public static class/*struct*/ tlv_descriptor {
  public Object/*uintptr_t*/ thunk;
  public Object/*uintptr_t*/ key;
  public Object/*uintptr_t*/ offset;
  
  @Override public String toString() {
    return "" + "thunk=" + thunk // NOI18N
              + ", key=" + key // NOI18N
              + ", offset=" + offset; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::entry_point_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 875,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 917,
 FQN="llvm::MachO::entry_point_command", NM="_ZN4llvm5MachO19entry_point_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19entry_point_commandE")
//</editor-fold>
public static class/*struct*/ entry_point_command {
  public /*uint32_t*/int cmd;
  public /*uint32_t*/int cmdsize;
  public long/*uint64_t*/ entryoff;
  public long/*uint64_t*/ stacksize;
  
  @Override public String toString() {
    return "" + "cmd=" + cmd // NOI18N
              + ", cmdsize=" + cmdsize // NOI18N
              + ", entryoff=" + entryoff // NOI18N
              + ", stacksize=" + stacksize; // NOI18N
  }
}

// Structs from <mach-o/fat.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_header">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 883,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 925,
 FQN="llvm::MachO::fat_header", NM="_ZN4llvm5MachO10fat_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10fat_headerE")
//</editor-fold>
public static class/*struct*/ fat_header {
  public /*uint32_t*/int magic;
  public /*uint32_t*/int nfat_arch;
  
  @Override public String toString() {
    return "" + "magic=" + magic // NOI18N
              + ", nfat_arch=" + nfat_arch; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 888,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 930,
 FQN="llvm::MachO::fat_arch", NM="_ZN4llvm5MachO8fat_archE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8fat_archE")
//</editor-fold>
public static class/*struct*/ fat_arch {
  public /*uint32_t*/int cputype;
  public /*uint32_t*/int cpusubtype;
  public /*uint32_t*/int offset;
  public /*uint32_t*/int size;
  public /*uint32_t*/int align;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch::fat_arch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 888,
   FQN="llvm::MachO::fat_arch::fat_arch", NM="_ZN4llvm5MachO8fat_archC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8fat_archC1ERKS1_")
  //</editor-fold>
  public /*inline*/ fat_arch(final /*const*/ fat_arch /*&*/ $Prm0) {
    // : cputype(.cputype), cpusubtype(.cpusubtype), offset(.offset), size(.size), align(.align) 
    //START JInit
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch::fat_arch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 888,
   FQN="llvm::MachO::fat_arch::fat_arch", NM="_ZN4llvm5MachO8fat_archC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8fat_archC1EOS1_")
  //</editor-fold>
  public /*inline*/ fat_arch(JD$Move _dparam, final fat_arch /*&&*/$Prm0) {
    // : cputype(static_cast<fat_arch &&>().cputype), cpusubtype(static_cast<fat_arch &&>().cpusubtype), offset(static_cast<fat_arch &&>().offset), size(static_cast<fat_arch &&>().size), align(static_cast<fat_arch &&>().align) 
    //START JInit
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 888,
   FQN="llvm::MachO::fat_arch::operator=", NM="_ZN4llvm5MachO8fat_archaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8fat_archaSEOS1_")
  //</editor-fold>
  public /*inline*/ fat_arch /*&*/ $assignMove(final fat_arch /*&&*/$Prm0) {
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "cputype=" + cputype // NOI18N
              + ", cpusubtype=" + cpusubtype // NOI18N
              + ", offset=" + offset // NOI18N
              + ", size=" + size // NOI18N
              + ", align=" + align; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 896,
 FQN="llvm::MachO::fat_arch_64", NM="_ZN4llvm5MachO11fat_arch_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11fat_arch_64E")
//</editor-fold>
public static class/*struct*/ fat_arch_64 {
  public /*uint32_t*/int cputype;
  public /*uint32_t*/int cpusubtype;
  public long/*uint64_t*/ offset;
  public long/*uint64_t*/ size;
  public /*uint32_t*/int align;
  public /*uint32_t*/int reserved;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch_64::fat_arch_64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 896,
   FQN="llvm::MachO::fat_arch_64::fat_arch_64", NM="_ZN4llvm5MachO11fat_arch_64C1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11fat_arch_64C1ERKS1_")
  //</editor-fold>
  public /*inline*/ fat_arch_64(final /*const*/ fat_arch_64 /*&*/ $Prm0) {
    // : cputype(.cputype), cpusubtype(.cpusubtype), offset(.offset), size(.size), align(.align), reserved(.reserved) 
    //START JInit
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    this.reserved = $Prm0.reserved;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch_64::fat_arch_64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 896,
   FQN="llvm::MachO::fat_arch_64::fat_arch_64", NM="_ZN4llvm5MachO11fat_arch_64C1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11fat_arch_64C1EOS1_")
  //</editor-fold>
  public /*inline*/ fat_arch_64(JD$Move _dparam, final fat_arch_64 /*&&*/$Prm0) {
    // : cputype(static_cast<fat_arch_64 &&>().cputype), cpusubtype(static_cast<fat_arch_64 &&>().cpusubtype), offset(static_cast<fat_arch_64 &&>().offset), size(static_cast<fat_arch_64 &&>().size), align(static_cast<fat_arch_64 &&>().align), reserved(static_cast<fat_arch_64 &&>().reserved) 
    //START JInit
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    this.reserved = $Prm0.reserved;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::fat_arch_64::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 896,
   FQN="llvm::MachO::fat_arch_64::operator=", NM="_ZN4llvm5MachO11fat_arch_64aSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11fat_arch_64aSEOS1_")
  //</editor-fold>
  public /*inline*/ fat_arch_64 /*&*/ $assignMove(final fat_arch_64 /*&&*/$Prm0) {
    this.cputype = $Prm0.cputype;
    this.cpusubtype = $Prm0.cpusubtype;
    this.offset = $Prm0.offset;
    this.size = $Prm0.size;
    this.align = $Prm0.align;
    this.reserved = $Prm0.reserved;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "cputype=" + cputype // NOI18N
              + ", cpusubtype=" + cpusubtype // NOI18N
              + ", offset=" + offset // NOI18N
              + ", size=" + size // NOI18N
              + ", align=" + align // NOI18N
              + ", reserved=" + reserved; // NOI18N
  }
}

// Structs from <mach-o/reloc.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::relocation_info">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 906,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 939,
 FQN="llvm::MachO::relocation_info", NM="_ZN4llvm5MachO15relocation_infoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15relocation_infoE")
//</editor-fold>
public static class/*struct*/ relocation_info {
  public int/*int32_t*/ r_address;
  public /*uint32_t*/int r_symbolnum /*: 24*/;
  public /*JBIT uint32_t*/ boolean r_pcrel /*: 1*/;
  public /*JBYTE uint32_t*/ byte r_length /*: 2*/;
  public /*JBIT uint32_t*/ boolean r_extern /*: 1*/;
  public /*JBYTE uint32_t*/ byte r_type /*: 4*/;
  
  @Override public String toString() {
    return "" + "r_address=" + r_address // NOI18N
              + ", r_symbolnum=" + r_symbolnum // NOI18N
              + ", r_pcrel=" + r_pcrel // NOI18N
              + ", r_length=" + $uchar2uint(r_length) // NOI18N
              + ", r_extern=" + r_extern // NOI18N
              + ", r_type=" + $uchar2uint(r_type); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::scattered_relocation_info">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 915,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 948,
 FQN="llvm::MachO::scattered_relocation_info", NM="_ZN4llvm5MachO25scattered_relocation_infoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO25scattered_relocation_infoE")
//</editor-fold>
public static class/*struct*/ scattered_relocation_info {
  public /*uint32_t*/int r_address /*: 24*/;
  public /*JBYTE uint32_t*/ byte r_type /*: 4*/;
  public /*JBYTE uint32_t*/ byte r_length /*: 2*/;
  public /*JBIT uint32_t*/ boolean r_pcrel /*: 1*/;
  public /*JBIT uint32_t*/ boolean r_scattered /*: 1*/;
  public int/*int32_t*/ r_value;
  
  @Override public String toString() {
    return "" + "r_address=" + r_address // NOI18N
              + ", r_type=" + $uchar2uint(r_type) // NOI18N
              + ", r_length=" + $uchar2uint(r_length) // NOI18N
              + ", r_pcrel=" + r_pcrel // NOI18N
              + ", r_scattered=" + r_scattered // NOI18N
              + ", r_value=" + r_value; // NOI18N
  }
}

// Structs NOT from <mach-o/reloc.h>, but that make LLVM's life easier
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::any_relocation_info">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 933,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 966,
 FQN="llvm::MachO::any_relocation_info", NM="_ZN4llvm5MachO19any_relocation_infoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19any_relocation_infoE")
//</editor-fold>
public static class/*struct*/ any_relocation_info {
  public /*uint32_t*/int r_word0;
  public /*uint32_t*/int r_word1;

  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::any_relocation_info::any_relocation_info">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 933,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 966,
   FQN="llvm::MachO::any_relocation_info::any_relocation_info", NM="_ZN4llvm5MachO19any_relocation_infoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm5MachO19any_relocation_infoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ any_relocation_info(final /*const*/ any_relocation_info /*&*/ $Prm0) {
    // : r_word0(.r_word0), r_word1(.r_word1) 
    //START JInit
    this.r_word0 = $Prm0.r_word0;
    this.r_word1 = $Prm0.r_word1;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::any_relocation_info::any_relocation_info">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 933,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 966,
   FQN="llvm::MachO::any_relocation_info::any_relocation_info", NM="_ZN4llvm5MachO19any_relocation_infoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MachObjectWriter.cpp -nm=_ZN4llvm5MachO19any_relocation_infoC1EOS1_")
  //</editor-fold>
  public /*inline*/ any_relocation_info(JD$Move _dparam, final any_relocation_info /*&&*/$Prm0) {
    // : r_word0(static_cast<any_relocation_info &&>().r_word0), r_word1(static_cast<any_relocation_info &&>().r_word1) 
    //START JInit
    this.r_word0 = $Prm0.r_word0;
    this.r_word1 = $Prm0.r_word1;
    //END JInit
  }

  
  public static int $sizeof_Any_relocation_info() {
    return 8;
  }
  
  @Override public String toString() {
    return "" + "r_word0=" + r_word0 // NOI18N
              + ", r_word1=" + r_word1; // NOI18N
  }
  }

// Structs from <mach-o/nlist.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::nlist_base">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 938,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 971,
 FQN="llvm::MachO::nlist_base", NM="_ZN4llvm5MachO10nlist_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10nlist_baseE")
//</editor-fold>
public static class/*struct*/ nlist_base {
  public /*uint32_t*/int n_strx;
  public byte/*uint8_t*/ n_type;
  public byte/*uint8_t*/ n_sect;
  public /*uint16_t*/char n_desc;
  
  @Override public String toString() {
    return "" + "n_strx=" + n_strx // NOI18N
              + ", n_type=" + $uchar2uint(n_type) // NOI18N
              + ", n_sect=" + $uchar2uint(n_sect) // NOI18N
              + ", n_desc=" + $ushort2uint(n_desc); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::nlist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 945,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 978,
 FQN="llvm::MachO::nlist", NM="_ZN4llvm5MachO5nlistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO5nlistE")
//</editor-fold>
public static class/*struct*/ nlist {
  public /*uint32_t*/int n_strx;
  public byte/*uint8_t*/ n_type;
  public byte/*uint8_t*/ n_sect;
  public short/*int16_t*/ n_desc;
  public /*uint32_t*/int n_value;

  public static int $sizeof_Nlist() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "n_strx=" + n_strx // NOI18N
              + ", n_type=" + $uchar2uint(n_type) // NOI18N
              + ", n_sect=" + $uchar2uint(n_sect) // NOI18N
              + ", n_desc=" + n_desc // NOI18N
              + ", n_value=" + n_value; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::nlist_64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 953,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 986,
 FQN="llvm::MachO::nlist_64", NM="_ZN4llvm5MachO8nlist_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO8nlist_64E")
//</editor-fold>
public static class/*struct*/ nlist_64 {
  public /*uint32_t*/int n_strx;
  public byte/*uint8_t*/ n_type;
  public byte/*uint8_t*/ n_sect;
  public /*uint16_t*/char n_desc;
  public long/*uint64_t*/ n_value;

  public static int $sizeof_Nlist_64() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "n_strx=" + n_strx // NOI18N
              + ", n_type=" + $uchar2uint(n_type) // NOI18N
              + ", n_sect=" + $uchar2uint(n_sect) // NOI18N
              + ", n_desc=" + $ushort2uint(n_desc) // NOI18N
              + ", n_value=" + n_value; // NOI18N
  }
  }

// Byte order swapping functions for MachO structs
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 963,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_10fat_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_10fat_headerE")
//</editor-fold>
public static /*inline*/ void swapStruct(final fat_header /*&*/ mh) {
  sys.swapByteOrder(mh.magic);
  sys.swapByteOrder(mh.nfat_arch);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 968,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_8fat_archE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_8fat_archE")
//</editor-fold>
public static /*inline*/ void swapStruct(final fat_arch /*&*/ mh) {
  sys.swapByteOrder(mh.cputype);
  sys.swapByteOrder(mh.cpusubtype);
  sys.swapByteOrder(mh.offset);
  sys.swapByteOrder(mh.size);
  sys.swapByteOrder(mh.align);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 976,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_11fat_arch_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_11fat_arch_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final fat_arch_64 /*&*/ mh) {
  sys.swapByteOrder(mh.cputype);
  sys.swapByteOrder(mh.cpusubtype);
  sys.swapByteOrder(mh.offset);
  sys.swapByteOrder(mh.size);
  sys.swapByteOrder(mh.align);
  sys.swapByteOrder(mh.reserved);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 985,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 996,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_11mach_headerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_11mach_headerE")
//</editor-fold>
public static /*inline*/ void swapStruct(final mach_header /*&*/ mh) {
  sys.swapByteOrder(mh.magic);
  sys.swapByteOrder(mh.cputype);
  sys.swapByteOrder(mh.cpusubtype);
  sys.swapByteOrder(mh.filetype);
  sys.swapByteOrder(mh.ncmds);
  sys.swapByteOrder(mh.sizeofcmds);
  sys.swapByteOrder(mh.flags);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 995,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1006,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_14mach_header_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_14mach_header_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final mach_header_64 /*&*/ H) {
  sys.swapByteOrder(H.magic);
  sys.swapByteOrder(H.cputype);
  sys.swapByteOrder(H.cpusubtype);
  sys.swapByteOrder(H.filetype);
  sys.swapByteOrder(H.ncmds);
  sys.swapByteOrder(H.sizeofcmds);
  sys.swapByteOrder(H.flags);
  sys.swapByteOrder(H.reserved);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1006,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1017,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_12load_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_12load_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final load_command /*&*/ lc) {
  sys.swapByteOrder(lc.cmd);
  sys.swapByteOrder(lc.cmdsize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1011,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1022,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_14symtab_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_14symtab_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final symtab_command /*&*/ lc) {
  sys.swapByteOrder(lc.cmd);
  sys.swapByteOrder(lc.cmdsize);
  sys.swapByteOrder(lc.symoff);
  sys.swapByteOrder(lc.nsyms);
  sys.swapByteOrder(lc.stroff);
  sys.swapByteOrder(lc.strsize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1020,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1031,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_18segment_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_18segment_command_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final segment_command_64 /*&*/ seg) {
  sys.swapByteOrder(seg.cmd);
  sys.swapByteOrder(seg.cmdsize);
  sys.swapByteOrder(seg.vmaddr);
  sys.swapByteOrder(seg.vmsize);
  sys.swapByteOrder(seg.fileoff);
  sys.swapByteOrder(seg.filesize);
  sys.swapByteOrder(seg.maxprot);
  sys.swapByteOrder(seg.initprot);
  sys.swapByteOrder(seg.nsects);
  sys.swapByteOrder(seg.flags);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1033,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1044,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_15segment_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_15segment_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final segment_command /*&*/ seg) {
  sys.swapByteOrder(seg.cmd);
  sys.swapByteOrder(seg.cmdsize);
  sys.swapByteOrder(seg.vmaddr);
  sys.swapByteOrder(seg.vmsize);
  sys.swapByteOrder(seg.fileoff);
  sys.swapByteOrder(seg.filesize);
  sys.swapByteOrder(seg.maxprot);
  sys.swapByteOrder(seg.initprot);
  sys.swapByteOrder(seg.nsects);
  sys.swapByteOrder(seg.flags);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1046,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1057,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_10section_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_10section_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final section_64 /*&*/ sect) {
  sys.swapByteOrder(sect.addr);
  sys.swapByteOrder(sect.size);
  sys.swapByteOrder(sect.offset);
  sys.swapByteOrder(sect.align);
  sys.swapByteOrder(sect.reloff);
  sys.swapByteOrder(sect.nreloc);
  sys.swapByteOrder(sect.flags);
  sys.swapByteOrder(sect.reserved1);
  sys.swapByteOrder(sect.reserved2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1058,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1069,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_7sectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_7sectionE")
//</editor-fold>
public static /*inline*/ void swapStruct(final section /*&*/ sect) {
  sys.swapByteOrder(sect.addr);
  sys.swapByteOrder(sect.size);
  sys.swapByteOrder(sect.offset);
  sys.swapByteOrder(sect.align);
  sys.swapByteOrder(sect.reloff);
  sys.swapByteOrder(sect.nreloc);
  sys.swapByteOrder(sect.flags);
  sys.swapByteOrder(sect.reserved1);
  sys.swapByteOrder(sect.reserved2);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1070,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1081,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_17dyld_info_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_17dyld_info_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final dyld_info_command /*&*/ info) {
  sys.swapByteOrder(info.cmd);
  sys.swapByteOrder(info.cmdsize);
  sys.swapByteOrder(info.rebase_off);
  sys.swapByteOrder(info.rebase_size);
  sys.swapByteOrder(info.bind_off);
  sys.swapByteOrder(info.bind_size);
  sys.swapByteOrder(info.weak_bind_off);
  sys.swapByteOrder(info.weak_bind_size);
  sys.swapByteOrder(info.lazy_bind_off);
  sys.swapByteOrder(info.lazy_bind_size);
  sys.swapByteOrder(info.export_off);
  sys.swapByteOrder(info.export_size);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1085,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1096,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_13dylib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_13dylib_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final dylib_command /*&*/ d) {
  sys.swapByteOrder(d.cmd);
  sys.swapByteOrder(d.cmdsize);
  sys.swapByteOrder(d.dylib.name);
  sys.swapByteOrder(d.dylib.timestamp);
  sys.swapByteOrder(d.dylib.current_version);
  sys.swapByteOrder(d.dylib.compatibility_version);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1094,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1105,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_21sub_framework_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_21sub_framework_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final sub_framework_command /*&*/ s) {
  sys.swapByteOrder(s.cmd);
  sys.swapByteOrder(s.cmdsize);
  sys.swapByteOrder(s.umbrella);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1100,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1111,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_20sub_umbrella_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_20sub_umbrella_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final sub_umbrella_command /*&*/ s) {
  sys.swapByteOrder(s.cmd);
  sys.swapByteOrder(s.cmdsize);
  sys.swapByteOrder(s.sub_umbrella);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1106,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1117,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19sub_library_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19sub_library_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final sub_library_command /*&*/ s) {
  sys.swapByteOrder(s.cmd);
  sys.swapByteOrder(s.cmdsize);
  sys.swapByteOrder(s.sub_library);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1112,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1123,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_18sub_client_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_18sub_client_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final sub_client_command /*&*/ s) {
  sys.swapByteOrder(s.cmd);
  sys.swapByteOrder(s.cmdsize);
  sys.swapByteOrder(s.client);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1118,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1129,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_16routines_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_16routines_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final routines_command /*&*/ r) {
  sys.swapByteOrder(r.cmd);
  sys.swapByteOrder(r.cmdsize);
  sys.swapByteOrder(r.init_address);
  sys.swapByteOrder(r.init_module);
  sys.swapByteOrder(r.reserved1);
  sys.swapByteOrder(r.reserved2);
  sys.swapByteOrder(r.reserved3);
  sys.swapByteOrder(r.reserved4);
  sys.swapByteOrder(r.reserved5);
  sys.swapByteOrder(r.reserved6);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1131,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1142,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19routines_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19routines_command_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final routines_command_64 /*&*/ r) {
  sys.swapByteOrder(r.cmd);
  sys.swapByteOrder(r.cmdsize);
  sys.swapByteOrder(r.init_address);
  sys.swapByteOrder(r.init_module);
  sys.swapByteOrder(r.reserved1);
  sys.swapByteOrder(r.reserved2);
  sys.swapByteOrder(r.reserved3);
  sys.swapByteOrder(r.reserved4);
  sys.swapByteOrder(r.reserved5);
  sys.swapByteOrder(r.reserved6);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1144,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1155,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_14thread_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_14thread_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final thread_command /*&*/ t) {
  sys.swapByteOrder(t.cmd);
  sys.swapByteOrder(t.cmdsize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1149,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1160,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_16dylinker_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_16dylinker_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final dylinker_command /*&*/ d) {
  sys.swapByteOrder(d.cmd);
  sys.swapByteOrder(d.cmdsize);
  sys.swapByteOrder(d.name);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1155,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1166,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_12uuid_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_12uuid_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final uuid_command /*&*/ u) {
  sys.swapByteOrder(u.cmd);
  sys.swapByteOrder(u.cmdsize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1160,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1171,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_13rpath_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_13rpath_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final rpath_command /*&*/ r) {
  sys.swapByteOrder(r.cmd);
  sys.swapByteOrder(r.cmdsize);
  sys.swapByteOrder(r._path);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1166,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1177,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_22source_version_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_22source_version_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final source_version_command /*&*/ s) {
  sys.swapByteOrder(s.cmd);
  sys.swapByteOrder(s.cmdsize);
  sys.swapByteOrder(s.version);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1172,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1183,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19entry_point_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19entry_point_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final entry_point_command /*&*/ e) {
  sys.swapByteOrder(e.cmd);
  sys.swapByteOrder(e.cmdsize);
  sys.swapByteOrder(e.entryoff);
  sys.swapByteOrder(e.stacksize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1179,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1190,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_23encryption_info_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_23encryption_info_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final encryption_info_command /*&*/ e) {
  sys.swapByteOrder(e.cmd);
  sys.swapByteOrder(e.cmdsize);
  sys.swapByteOrder(e.cryptoff);
  sys.swapByteOrder(e.cryptsize);
  sys.swapByteOrder(e.cryptid);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1187,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1198,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_26encryption_info_command_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_26encryption_info_command_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final encryption_info_command_64 /*&*/ e) {
  sys.swapByteOrder(e.cmd);
  sys.swapByteOrder(e.cmdsize);
  sys.swapByteOrder(e.cryptoff);
  sys.swapByteOrder(e.cryptsize);
  sys.swapByteOrder(e.cryptid);
  sys.swapByteOrder(e.pad);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1196,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1207,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_16dysymtab_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_16dysymtab_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final dysymtab_command /*&*/ dst) {
  sys.swapByteOrder(dst.cmd);
  sys.swapByteOrder(dst.cmdsize);
  sys.swapByteOrder(dst.ilocalsym);
  sys.swapByteOrder(dst.nlocalsym);
  sys.swapByteOrder(dst.iextdefsym);
  sys.swapByteOrder(dst.nextdefsym);
  sys.swapByteOrder(dst.iundefsym);
  sys.swapByteOrder(dst.nundefsym);
  sys.swapByteOrder(dst.tocoff);
  sys.swapByteOrder(dst.ntoc);
  sys.swapByteOrder(dst.modtaboff);
  sys.swapByteOrder(dst.nmodtab);
  sys.swapByteOrder(dst.extrefsymoff);
  sys.swapByteOrder(dst.nextrefsyms);
  sys.swapByteOrder(dst.indirectsymoff);
  sys.swapByteOrder(dst.nindirectsyms);
  sys.swapByteOrder(dst.extreloff);
  sys.swapByteOrder(dst.nextrel);
  sys.swapByteOrder(dst.locreloff);
  sys.swapByteOrder(dst.nlocrel);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1219,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1230,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19any_relocation_infoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19any_relocation_infoE")
//</editor-fold>
public static /*inline*/ void swapStruct(final any_relocation_info /*&*/ reloc) {
  sys.swapByteOrder(reloc.r_word0);
  sys.swapByteOrder(reloc.r_word1);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1224,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1235,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_10nlist_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_10nlist_baseE")
//</editor-fold>
public static /*inline*/ void swapStruct(final nlist_base /*&*/ S) {
  sys.swapByteOrder(S.n_strx);
  sys.swapByteOrder(S.n_desc);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1229,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1240,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_5nlistE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_5nlistE")
//</editor-fold>
public static /*inline*/ void swapStruct(final nlist /*&*/ sym) {
  sys.swapByteOrder(sym.n_strx);
  sys.swapByteOrder(sym.n_desc);
  sys.swapByteOrder(sym.n_value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1235,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1246,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_8nlist_64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_8nlist_64E")
//</editor-fold>
public static /*inline*/ void swapStruct(final nlist_64 /*&*/ sym) {
  sys.swapByteOrder(sym.n_strx);
  sys.swapByteOrder(sym.n_desc);
  sys.swapByteOrder(sym.n_value);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1241,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1252,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_21linkedit_data_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_21linkedit_data_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final linkedit_data_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.dataoff);
  sys.swapByteOrder(C.datasize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1248,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1259,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_21linker_option_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_21linker_option_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final linker_option_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.count);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1254,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1265,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19version_min_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19version_min_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final version_min_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.version);
  sys.swapByteOrder(C.sdk);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1261,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1272,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_18data_in_code_entryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_18data_in_code_entryE")
//</editor-fold>
public static /*inline*/ void swapStruct(final data_in_code_entry /*&*/ C) {
  sys.swapByteOrder(C.offset);
  sys.swapByteOrder(C.length);
  sys.swapByteOrder(C.kind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1278,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERj")
//</editor-fold>
public static /*inline*/ void swapStruct(final /*uint32_t &*/uint$ref C) {
  sys.swapByteOrder(C);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1271,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_21prebind_cksum_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_21prebind_cksum_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final prebind_cksum_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.cksum);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1277,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_22twolevel_hints_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_22twolevel_hints_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final twolevel_hints_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.offset);
  sys.swapByteOrder(C.nhints);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1284,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_22prebound_dylib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_22prebound_dylib_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final prebound_dylib_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.name);
  sys.swapByteOrder(C.nmodules);
  sys.swapByteOrder(C.linked_modules);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1292,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_15fvmfile_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_15fvmfile_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final fvmfile_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.name);
  sys.swapByteOrder(C.header_addr);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1299,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_14symseg_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_14symseg_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final symseg_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  sys.swapByteOrder(C.offset);
  sys.swapByteOrder(C.size);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1306,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_13ident_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_13ident_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final ident_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1311,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_6fvmlibE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_6fvmlibE")
//</editor-fold>
public static /*inline*/ void swapStruct(final fvmlib /*&*/ C) {
  sys.swapByteOrder(C.name);
  sys.swapByteOrder(C.minor_version);
  sys.swapByteOrder(C.header_addr);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1317,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_14fvmlib_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_14fvmlib_commandE")
//</editor-fold>
public static /*inline*/ void swapStruct(final fvmlib_command /*&*/ C) {
  sys.swapByteOrder(C.cmd);
  sys.swapByteOrder(C.cmdsize);
  swapStruct(C.fvmlib);
}


// Get/Set functions from <mach-o/nlist.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::GET_LIBRARY_ORDINAL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1325,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1284,
 FQN="llvm::MachO::GET_LIBRARY_ORDINAL", NM="_ZN4llvm5MachOL19GET_LIBRARY_ORDINALEt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL19GET_LIBRARY_ORDINALEt")
//</editor-fold>
public static /*inline*/ /*uint16_t*/char GET_LIBRARY_ORDINAL(/*uint16_t*/char n_desc) {
  return $uint2ushort((($ushort2int((n_desc)) >> 8/*U*/) & 0xff/*U*/));
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::SET_LIBRARY_ORDINAL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1329,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1288,
 FQN="llvm::MachO::SET_LIBRARY_ORDINAL", NM="_ZN4llvm5MachOL19SET_LIBRARY_ORDINALERth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL19SET_LIBRARY_ORDINALERth")
//</editor-fold>
public static /*inline*/ void SET_LIBRARY_ORDINAL(final /*uint16_t*/ushort$ref/*&*/ n_desc, byte/*uint8_t*/ ordinal) {
  n_desc.$assign($int2ushort((($ushort2int((n_desc.$deref())) & 0x00ff) | (($uchar2int((ordinal)) & 0xff) << 8))));
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::GET_COMM_ALIGN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1333,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1292,
 FQN="llvm::MachO::GET_COMM_ALIGN", NM="_ZN4llvm5MachOL14GET_COMM_ALIGNEt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL14GET_COMM_ALIGNEt")
//</editor-fold>
public static /*inline*/ byte/*uint8_t*/ GET_COMM_ALIGN(/*uint16_t*/char n_desc) {
  return $uint2uchar(($ushort2int(n_desc) >> 8/*U*/) & 0x0f/*U*/);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::SET_COMM_ALIGN">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1337,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1296,
 FQN="llvm::MachO::SET_COMM_ALIGN", NM="_ZN4llvm5MachOL14SET_COMM_ALIGNERth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL14SET_COMM_ALIGNERth")
//</editor-fold>
public static /*inline*/ void SET_COMM_ALIGN(final /*uint16_t*/ushort$ref/*&*/ n_desc, byte/*uint8_t*/ align) {
  n_desc.$assign($uint2ushort((($ushort2uint(n_desc.$deref()) & 0xf0ff/*U*/) | (($uchar2uint(align) & 0x0f/*U*/) << 8/*U*/))));
}


// Enums from <mach/machine.h>
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1342,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1301,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum26",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum26")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Capability bits used in the definition of cpu_type.
  public static final /*uint32_t*/int CPU_ARCH_MASK = 0xff000000/*U*/; // Mask for architecture bits
  public static final /*uint32_t*/int CPU_ARCH_ABI64 = 0x01000000; // 64 bit ABI
/*}*/

// Constants for the cputype field.
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1349,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1308,
 FQN="llvm::MachO::CPUType", NM="_ZN4llvm5MachO7CPUTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO7CPUTypeE")
//</editor-fold>
public enum CPUType implements Native.NativeIntEnum {
  CPU_TYPE_ANY(-1),
  CPU_TYPE_X86(7),
  CPU_TYPE_I386(CPUType.CPU_TYPE_X86.getValue()),
  CPU_TYPE_X86_64(CPUType.CPU_TYPE_X86.getValue() | CPU_ARCH_ABI64),
  /* CPU_TYPE_MIPS      = 8, */
  CPU_TYPE_MC98000(10), // Old Motorola PowerPC
  CPU_TYPE_ARM(12),
  CPU_TYPE_ARM64(CPUType.CPU_TYPE_ARM.getValue() | CPU_ARCH_ABI64),
  CPU_TYPE_SPARC(14),
  CPU_TYPE_POWERPC(18),
  CPU_TYPE_POWERPC64(CPUType.CPU_TYPE_POWERPC.getValue() | CPU_ARCH_ABI64);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUType valueOf(int val) {
    CPUType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUType[] VALUES;
    private static final CPUType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUType kind : CPUType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUType[min < 0 ? (1-min) : 0];
      VALUES = new CPUType[max >= 0 ? (1+max) : 0];
      for (CPUType kind : CPUType.values()) {
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
  private CPUType(int val) { this.value = (int)val;}
  @Override public final int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1363,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1322,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum28",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum28")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
  // Capability bits used in the definition of cpusubtype.
  public static final /*uint32_t*/int CPU_SUBTYPE_MASK = 0xff000000/*U*/; // Mask for architecture bits
  public static final /*uint32_t*/int CPU_SUBTYPE_LIB64 = 0x80000000/*U*/; // 64 bit libraries
  
  // Special CPU subtype constants.
  public static final /*uint32_t*/int CPU_SUBTYPE_MULTIPLE = ~0/*U*/;
/*}*/

// Constants for the cpusubtype field.
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUSubTypeX86">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1373,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1332,
 FQN="llvm::MachO::CPUSubTypeX86", NM="_ZN4llvm5MachO13CPUSubTypeX86E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13CPUSubTypeX86E")
//</editor-fold>
public static final class/*enum*/ CPUSubTypeX86 {
  public static final /*uint*/int CPU_SUBTYPE_I386_ALL = 3;
  public static final /*uint*/int CPU_SUBTYPE_386 = 3;
  public static final /*uint*/int CPU_SUBTYPE_486 = 4;
  public static final /*uint*/int CPU_SUBTYPE_486SX = 0x84;
  public static final /*uint*/int CPU_SUBTYPE_586 = 5;
  public static final /*uint*/int CPU_SUBTYPE_PENT = CPUSubTypeX86.CPU_SUBTYPE_586;
  public static final /*uint*/int CPU_SUBTYPE_PENTPRO = 0x16;
  public static final /*uint*/int CPU_SUBTYPE_PENTII_M3 = 0x36;
  public static final /*uint*/int CPU_SUBTYPE_PENTII_M5 = 0x56;
  public static final /*uint*/int CPU_SUBTYPE_CELERON = 0x67;
  public static final /*uint*/int CPU_SUBTYPE_CELERON_MOBILE = 0x77;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_3 = 0x08;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_3_M = 0x18;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_3_XEON = 0x28;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_M = 0x09;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_4 = 0x0a;
  public static final /*uint*/int CPU_SUBTYPE_PENTIUM_4_M = 0x1a;
  public static final /*uint*/int CPU_SUBTYPE_ITANIUM = 0x0b;
  public static final /*uint*/int CPU_SUBTYPE_ITANIUM_2 = 0x1b;
  public static final /*uint*/int CPU_SUBTYPE_XEON = 0x0c;
  public static final /*uint*/int CPU_SUBTYPE_XEON_MP = 0x1c;
  
  public static final /*uint*/int CPU_SUBTYPE_X86_ALL = 3;
  public static final /*uint*/int CPU_SUBTYPE_X86_64_ALL = 3;
  public static final /*uint*/int CPU_SUBTYPE_X86_ARCH1 = 4;
  public static final /*uint*/int CPU_SUBTYPE_X86_64_H = 8;
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPU_SUBTYPE_INTEL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1401,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1360,
 FQN="llvm::MachO::CPU_SUBTYPE_INTEL", NM="_ZN4llvm5MachOL17CPU_SUBTYPE_INTELEii",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL17CPU_SUBTYPE_INTELEii")
//</editor-fold>
public static /*inline*/ int CPU_SUBTYPE_INTEL(int Family, int Model) {
  return Family | (Model << 4);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPU_SUBTYPE_INTEL_FAMILY">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1404,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1363,
 FQN="llvm::MachO::CPU_SUBTYPE_INTEL_FAMILY", NM="_ZN4llvm5MachOL24CPU_SUBTYPE_INTEL_FAMILYENS0_13CPUSubTypeX86E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL24CPU_SUBTYPE_INTEL_FAMILYENS0_13CPUSubTypeX86E")
//</editor-fold>
public static /*inline*/ int CPU_SUBTYPE_INTEL_FAMILY(/*CPUSubTypeX86*//*uint*/int ST) {
  return ((int)ST) & 0x0f;
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPU_SUBTYPE_INTEL_MODEL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1407,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1366,
 FQN="llvm::MachO::CPU_SUBTYPE_INTEL_MODEL", NM="_ZN4llvm5MachOL23CPU_SUBTYPE_INTEL_MODELENS0_13CPUSubTypeX86E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL23CPU_SUBTYPE_INTEL_MODELENS0_13CPUSubTypeX86E")
//</editor-fold>
public static /*inline*/ int CPU_SUBTYPE_INTEL_MODEL(/*CPUSubTypeX86*//*uint*/int ST) {
  return ((int)ST) >> 4;
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1410,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1369,
 FQN="llvm::MachO::(anonymous)", NM="_ZN4llvm5MachOE_MachO_h_Unnamed_enum30",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOE_MachO_h_Unnamed_enum30")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int CPU_SUBTYPE_INTEL_FAMILY_MAX = 15;
  public static final /*uint*/int CPU_SUBTYPE_INTEL_MODEL_ALL = 0;
/*}*/
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUSubTypeARM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1415,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1374,
 FQN="llvm::MachO::CPUSubTypeARM", NM="_ZN4llvm5MachO13CPUSubTypeARME",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO13CPUSubTypeARME")
//</editor-fold>
public enum CPUSubTypeARM implements Native.NativeUIntEnum {
  CPU_SUBTYPE_ARM_ALL(0),
  CPU_SUBTYPE_ARM_V4T(5),
  CPU_SUBTYPE_ARM_V6(6),
  CPU_SUBTYPE_ARM_V5(7),
  CPU_SUBTYPE_ARM_V5TEJ(7),
  CPU_SUBTYPE_ARM_XSCALE(8),
  CPU_SUBTYPE_ARM_V7(9),
  //  unused  ARM_V7F     = 10,
  CPU_SUBTYPE_ARM_V7S(11),
  CPU_SUBTYPE_ARM_V7K(12),
  CPU_SUBTYPE_ARM_V6M(14),
  CPU_SUBTYPE_ARM_V7M(15),
  CPU_SUBTYPE_ARM_V7EM(16);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUSubTypeARM valueOf(int val) {
    CPUSubTypeARM out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUSubTypeARM[] VALUES;
    private static final CPUSubTypeARM[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUSubTypeARM kind : CPUSubTypeARM.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUSubTypeARM[min < 0 ? (1-min) : 0];
      VALUES = new CPUSubTypeARM[max >= 0 ? (1+max) : 0];
      for (CPUSubTypeARM kind : CPUSubTypeARM.values()) {
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

  private final /*uint*/int value;
  private CPUSubTypeARM(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUSubTypeARM64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1431,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1390,
 FQN="llvm::MachO::CPUSubTypeARM64", NM="_ZN4llvm5MachO15CPUSubTypeARM64E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15CPUSubTypeARM64E")
//</editor-fold>
public enum CPUSubTypeARM64 implements Native.NativeUIntEnum {
  CPU_SUBTYPE_ARM64_ALL(0);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUSubTypeARM64 valueOf(int val) {
    CPUSubTypeARM64 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUSubTypeARM64[] VALUES;
    private static final CPUSubTypeARM64[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUSubTypeARM64 kind : CPUSubTypeARM64.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUSubTypeARM64[min < 0 ? (1-min) : 0];
      VALUES = new CPUSubTypeARM64[max >= 0 ? (1+max) : 0];
      for (CPUSubTypeARM64 kind : CPUSubTypeARM64.values()) {
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

  private final /*uint*/int value;
  private CPUSubTypeARM64(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUSubTypeSPARC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1435,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1394,
 FQN="llvm::MachO::CPUSubTypeSPARC", NM="_ZN4llvm5MachO15CPUSubTypeSPARCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15CPUSubTypeSPARCE")
//</editor-fold>
public enum CPUSubTypeSPARC implements Native.NativeUIntEnum {
  CPU_SUBTYPE_SPARC_ALL(0);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUSubTypeSPARC valueOf(int val) {
    CPUSubTypeSPARC out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUSubTypeSPARC[] VALUES;
    private static final CPUSubTypeSPARC[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUSubTypeSPARC kind : CPUSubTypeSPARC.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUSubTypeSPARC[min < 0 ? (1-min) : 0];
      VALUES = new CPUSubTypeSPARC[max >= 0 ? (1+max) : 0];
      for (CPUSubTypeSPARC kind : CPUSubTypeSPARC.values()) {
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

  private final /*uint*/int value;
  private CPUSubTypeSPARC(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::CPUSubTypePowerPC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1439,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1398,
 FQN="llvm::MachO::CPUSubTypePowerPC", NM="_ZN4llvm5MachO17CPUSubTypePowerPCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17CPUSubTypePowerPCE")
//</editor-fold>
public enum CPUSubTypePowerPC implements Native.NativeUIntEnum {
  CPU_SUBTYPE_POWERPC_ALL(0),
  CPU_SUBTYPE_POWERPC_601(1),
  CPU_SUBTYPE_POWERPC_602(2),
  CPU_SUBTYPE_POWERPC_603(3),
  CPU_SUBTYPE_POWERPC_603e(4),
  CPU_SUBTYPE_POWERPC_603ev(5),
  CPU_SUBTYPE_POWERPC_604(6),
  CPU_SUBTYPE_POWERPC_604e(7),
  CPU_SUBTYPE_POWERPC_620(8),
  CPU_SUBTYPE_POWERPC_750(9),
  CPU_SUBTYPE_POWERPC_7400(10),
  CPU_SUBTYPE_POWERPC_7450(11),
  CPU_SUBTYPE_POWERPC_970(100),
  
  CPU_SUBTYPE_MC980000_ALL(CPUSubTypePowerPC.CPU_SUBTYPE_POWERPC_ALL.getValue()),
  CPU_SUBTYPE_MC98601(CPUSubTypePowerPC.CPU_SUBTYPE_POWERPC_601.getValue());

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUSubTypePowerPC valueOf(int val) {
    CPUSubTypePowerPC out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUSubTypePowerPC[] VALUES;
    private static final CPUSubTypePowerPC[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUSubTypePowerPC kind : CPUSubTypePowerPC.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUSubTypePowerPC[min < 0 ? (1-min) : 0];
      VALUES = new CPUSubTypePowerPC[max >= 0 ? (1+max) : 0];
      for (CPUSubTypePowerPC kind : CPUSubTypePowerPC.values()) {
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

  private final /*uint*/int value;
  private CPUSubTypePowerPC(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_thread_state64_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1458,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1417,
 FQN="llvm::MachO::x86_thread_state64_t", NM="_ZN4llvm5MachO20x86_thread_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO20x86_thread_state64_tE")
//</editor-fold>
public static class/*struct*/ x86_thread_state64_t {
  public long/*uint64_t*/ rax;
  public long/*uint64_t*/ rbx;
  public long/*uint64_t*/ rcx;
  public long/*uint64_t*/ rdx;
  public long/*uint64_t*/ rdi;
  public long/*uint64_t*/ rsi;
  public long/*uint64_t*/ rbp;
  public long/*uint64_t*/ rsp;
  public long/*uint64_t*/ r8;
  public long/*uint64_t*/ r9;
  public long/*uint64_t*/ r10;
  public long/*uint64_t*/ r11;
  public long/*uint64_t*/ r12;
  public long/*uint64_t*/ r13;
  public long/*uint64_t*/ r14;
  public long/*uint64_t*/ r15;
  public long/*uint64_t*/ rip;
  public long/*uint64_t*/ rflags;
  public long/*uint64_t*/ cs;
  public long/*uint64_t*/ fs;
  public long/*uint64_t*/ gs;
  
  public static int $sizeof_X86_thread_state64_t() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override public String toString() {
    return "" + "rax=" + rax // NOI18N
              + ", rbx=" + rbx // NOI18N
              + ", rcx=" + rcx // NOI18N
              + ", rdx=" + rdx // NOI18N
              + ", rdi=" + rdi // NOI18N
              + ", rsi=" + rsi // NOI18N
              + ", rbp=" + rbp // NOI18N
              + ", rsp=" + rsp // NOI18N
              + ", r8=" + r8 // NOI18N
              + ", r9=" + r9 // NOI18N
              + ", r10=" + r10 // NOI18N
              + ", r11=" + r11 // NOI18N
              + ", r12=" + r12 // NOI18N
              + ", r13=" + r13 // NOI18N
              + ", r14=" + r14 // NOI18N
              + ", r15=" + r15 // NOI18N
              + ", rip=" + rip // NOI18N
              + ", rflags=" + rflags // NOI18N
              + ", cs=" + cs // NOI18N
              + ", fs=" + fs // NOI18N
              + ", gs=" + gs; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_fp_control_precis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1482,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1441,
 FQN="llvm::MachO::x86_fp_control_precis", NM="_ZN4llvm5MachO21x86_fp_control_precisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21x86_fp_control_precisE")
//</editor-fold>
public enum x86_fp_control_precis implements Native.NativeUIntEnum {
  x86_FP_PREC_24B(0),
  x86_FP_PREC_53B(2),
  x86_FP_PREC_64B(3);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static x86_fp_control_precis valueOf(int val) {
    x86_fp_control_precis out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final x86_fp_control_precis[] VALUES;
    private static final x86_fp_control_precis[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (x86_fp_control_precis kind : x86_fp_control_precis.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new x86_fp_control_precis[min < 0 ? (1-min) : 0];
      VALUES = new x86_fp_control_precis[max >= 0 ? (1+max) : 0];
      for (x86_fp_control_precis kind : x86_fp_control_precis.values()) {
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

  private final /*uint*/int value;
  private x86_fp_control_precis(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_fp_control_rc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1488,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1447,
 FQN="llvm::MachO::x86_fp_control_rc", NM="_ZN4llvm5MachO17x86_fp_control_rcE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17x86_fp_control_rcE")
//</editor-fold>
public enum x86_fp_control_rc implements Native.NativeUIntEnum {
  x86_FP_RND_NEAR(0),
  x86_FP_RND_DOWN(1),
  x86_FP_RND_UP(2),
  x86_FP_CHOP(3);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static x86_fp_control_rc valueOf(int val) {
    x86_fp_control_rc out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final x86_fp_control_rc[] VALUES;
    private static final x86_fp_control_rc[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (x86_fp_control_rc kind : x86_fp_control_rc.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new x86_fp_control_rc[min < 0 ? (1-min) : 0];
      VALUES = new x86_fp_control_rc[max >= 0 ? (1+max) : 0];
      for (x86_fp_control_rc kind : x86_fp_control_rc.values()) {
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

  private final /*uint*/int value;
  private x86_fp_control_rc(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fp_control_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1495,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1454,
 FQN="llvm::MachO::fp_control_t", NM="_ZN4llvm5MachO12fp_control_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO12fp_control_tE")
//</editor-fold>
public static class/*struct*/ fp_control_t {
  public /*JBIT unsigned short*/ boolean invalid /*: 1*/;
  public /*JBIT unsigned short*/ boolean denorm /*: 1*/;
  public /*JBIT unsigned short*/ boolean zdiv /*: 1*/;
  public /*JBIT unsigned short*/ boolean ovrfl /*: 1*/;
  public /*JBIT unsigned short*/ boolean undfl /*: 1*/;
  public /*JBIT unsigned short*/ boolean precis /*: 1*/;
  public /*JBYTE unsigned short*/ byte Unnamed_field6 /*: 2*/;
  public /*JBYTE unsigned short*/ byte pc /*: 2*/;
  public /*JBYTE unsigned short*/ byte rc /*: 2*/;
  public /*JBIT unsigned short*/ boolean Unnamed_field9 /*: 1*/;
  public /*JBYTE unsigned short*/ byte Unnamed_field10 /*: 3*/;
  
  @Override public String toString() {
    return "" + "invalid=" + invalid // NOI18N
              + ", denorm=" + denorm // NOI18N
              + ", zdiv=" + zdiv // NOI18N
              + ", ovrfl=" + ovrfl // NOI18N
              + ", undfl=" + undfl // NOI18N
              + ", precis=" + precis // NOI18N
              + ", Unnamed_field6=" + $uchar2uint(Unnamed_field6) // NOI18N
              + ", pc=" + $uchar2uint(pc) // NOI18N
              + ", rc=" + $uchar2uint(rc) // NOI18N
              + ", Unnamed_field9=" + Unnamed_field9 // NOI18N
              + ", Unnamed_field10=" + $uchar2uint(Unnamed_field10); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::fp_status_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1510,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1469,
 FQN="llvm::MachO::fp_status_t", NM="_ZN4llvm5MachO11fp_status_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO11fp_status_tE")
//</editor-fold>
public static class/*struct*/ fp_status_t {
  public /*JBIT unsigned short*/ boolean invalid /*: 1*/;
  public /*JBIT unsigned short*/ boolean denorm /*: 1*/;
  public /*JBIT unsigned short*/ boolean zdiv /*: 1*/;
  public /*JBIT unsigned short*/ boolean ovrfl /*: 1*/;
  public /*JBIT unsigned short*/ boolean undfl /*: 1*/;
  public /*JBIT unsigned short*/ boolean precis /*: 1*/;
  public /*JBIT unsigned short*/ boolean stkflt /*: 1*/;
  public /*JBIT unsigned short*/ boolean errsumm /*: 1*/;
  public /*JBIT unsigned short*/ boolean c0 /*: 1*/;
  public /*JBIT unsigned short*/ boolean c1 /*: 1*/;
  public /*JBIT unsigned short*/ boolean c2 /*: 1*/;
  public /*JBYTE unsigned short*/ byte tos /*: 3*/;
  public /*JBIT unsigned short*/ boolean c3 /*: 1*/;
  public /*JBIT unsigned short*/ boolean busy /*: 1*/;
  
  @Override public String toString() {
    return "" + "invalid=" + invalid // NOI18N
              + ", denorm=" + denorm // NOI18N
              + ", zdiv=" + zdiv // NOI18N
              + ", ovrfl=" + ovrfl // NOI18N
              + ", undfl=" + undfl // NOI18N
              + ", precis=" + precis // NOI18N
              + ", stkflt=" + stkflt // NOI18N
              + ", errsumm=" + errsumm // NOI18N
              + ", c0=" + c0 // NOI18N
              + ", c1=" + c1 // NOI18N
              + ", c2=" + c2 // NOI18N
              + ", tos=" + $uchar2uint(tos) // NOI18N
              + ", c3=" + c3 // NOI18N
              + ", busy=" + busy; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::mmst_reg_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1528,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1487,
 FQN="llvm::MachO::mmst_reg_t", NM="_ZN4llvm5MachO10mmst_reg_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10mmst_reg_tE")
//</editor-fold>
public static class/*struct*/ mmst_reg_t {
  public /*char*/byte mmst_reg[/*10*/] = new$char(10);
  public /*char*/byte mmst_rsrv[/*6*/] = new$char(6);
  
  @Override public String toString() {
    return "" + "mmst_reg=" + mmst_reg // NOI18N
              + ", mmst_rsrv=" + mmst_rsrv; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::xmm_reg_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1533,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1492,
 FQN="llvm::MachO::xmm_reg_t", NM="_ZN4llvm5MachO9xmm_reg_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO9xmm_reg_tE")
//</editor-fold>
public static class/*struct*/ xmm_reg_t {
  public /*char*/byte xmm_reg[/*16*/] = new$char(16);
  
  @Override public String toString() {
    return "" + "xmm_reg=" + xmm_reg; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_float_state64_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1537,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1496,
 FQN="llvm::MachO::x86_float_state64_t", NM="_ZN4llvm5MachO19x86_float_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO19x86_float_state64_tE")
//</editor-fold>
public static class/*struct*/ x86_float_state64_t {
  public int/*int32_t*/ fpu_reserved[/*2*/] = new int/*int32_t*/ [2];
  public fp_control_t fpu_fcw;
  public fp_status_t fpu_fsw;
  public byte/*uint8_t*/ fpu_ftw;
  public byte/*uint8_t*/ fpu_rsrv1;
  public /*uint16_t*/char fpu_fop;
  public /*uint32_t*/int fpu_ip;
  public /*uint16_t*/char fpu_cs;
  public /*uint16_t*/char fpu_rsrv2;
  public /*uint32_t*/int fpu_dp;
  public /*uint16_t*/char fpu_ds;
  public /*uint16_t*/char fpu_rsrv3;
  public /*uint32_t*/int fpu_mxcsr;
  public /*uint32_t*/int fpu_mxcsrmask;
  public mmst_reg_t fpu_stmm0;
  public mmst_reg_t fpu_stmm1;
  public mmst_reg_t fpu_stmm2;
  public mmst_reg_t fpu_stmm3;
  public mmst_reg_t fpu_stmm4;
  public mmst_reg_t fpu_stmm5;
  public mmst_reg_t fpu_stmm6;
  public mmst_reg_t fpu_stmm7;
  public xmm_reg_t fpu_xmm0;
  public xmm_reg_t fpu_xmm1;
  public xmm_reg_t fpu_xmm2;
  public xmm_reg_t fpu_xmm3;
  public xmm_reg_t fpu_xmm4;
  public xmm_reg_t fpu_xmm5;
  public xmm_reg_t fpu_xmm6;
  public xmm_reg_t fpu_xmm7;
  public xmm_reg_t fpu_xmm8;
  public xmm_reg_t fpu_xmm9;
  public xmm_reg_t fpu_xmm10;
  public xmm_reg_t fpu_xmm11;
  public xmm_reg_t fpu_xmm12;
  public xmm_reg_t fpu_xmm13;
  public xmm_reg_t fpu_xmm14;
  public xmm_reg_t fpu_xmm15;
  public /*char*/byte fpu_rsrv4[/*96*/] = new$char(96);
  public /*uint32_t*/int fpu_reserved1;
  
  public static final int $sizeof_X86_float_state64_t(){
    throw new UnsupportedOperationException();
  }
  
  @Override public String toString() {
    return "" + "fpu_reserved=" + fpu_reserved // NOI18N
              + ", fpu_fcw=" + fpu_fcw // NOI18N
              + ", fpu_fsw=" + fpu_fsw // NOI18N
              + ", fpu_ftw=" + $uchar2uint(fpu_ftw) // NOI18N
              + ", fpu_rsrv1=" + $uchar2uint(fpu_rsrv1) // NOI18N
              + ", fpu_fop=" + $ushort2uint(fpu_fop) // NOI18N
              + ", fpu_ip=" + fpu_ip // NOI18N
              + ", fpu_cs=" + $ushort2uint(fpu_cs) // NOI18N
              + ", fpu_rsrv2=" + $ushort2uint(fpu_rsrv2) // NOI18N
              + ", fpu_dp=" + fpu_dp // NOI18N
              + ", fpu_ds=" + $ushort2uint(fpu_ds) // NOI18N
              + ", fpu_rsrv3=" + $ushort2uint(fpu_rsrv3) // NOI18N
              + ", fpu_mxcsr=" + fpu_mxcsr // NOI18N
              + ", fpu_mxcsrmask=" + fpu_mxcsrmask // NOI18N
              + ", fpu_stmm0=" + fpu_stmm0 // NOI18N
              + ", fpu_stmm1=" + fpu_stmm1 // NOI18N
              + ", fpu_stmm2=" + fpu_stmm2 // NOI18N
              + ", fpu_stmm3=" + fpu_stmm3 // NOI18N
              + ", fpu_stmm4=" + fpu_stmm4 // NOI18N
              + ", fpu_stmm5=" + fpu_stmm5 // NOI18N
              + ", fpu_stmm6=" + fpu_stmm6 // NOI18N
              + ", fpu_stmm7=" + fpu_stmm7 // NOI18N
              + ", fpu_xmm0=" + fpu_xmm0 // NOI18N
              + ", fpu_xmm1=" + fpu_xmm1 // NOI18N
              + ", fpu_xmm2=" + fpu_xmm2 // NOI18N
              + ", fpu_xmm3=" + fpu_xmm3 // NOI18N
              + ", fpu_xmm4=" + fpu_xmm4 // NOI18N
              + ", fpu_xmm5=" + fpu_xmm5 // NOI18N
              + ", fpu_xmm6=" + fpu_xmm6 // NOI18N
              + ", fpu_xmm7=" + fpu_xmm7 // NOI18N
              + ", fpu_xmm8=" + fpu_xmm8 // NOI18N
              + ", fpu_xmm9=" + fpu_xmm9 // NOI18N
              + ", fpu_xmm10=" + fpu_xmm10 // NOI18N
              + ", fpu_xmm11=" + fpu_xmm11 // NOI18N
              + ", fpu_xmm12=" + fpu_xmm12 // NOI18N
              + ", fpu_xmm13=" + fpu_xmm13 // NOI18N
              + ", fpu_xmm14=" + fpu_xmm14 // NOI18N
              + ", fpu_xmm15=" + fpu_xmm15 // NOI18N
              + ", fpu_rsrv4=" + fpu_rsrv4 // NOI18N
              + ", fpu_reserved1=" + fpu_reserved1; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_exception_state64_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1580,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1539,
 FQN="llvm::MachO::x86_exception_state64_t", NM="_ZN4llvm5MachO23x86_exception_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO23x86_exception_state64_tE")
//</editor-fold>
public static class/*struct*/ x86_exception_state64_t {
  public /*uint16_t*/char trapno;
  public /*uint16_t*/char cpu;
  public /*uint32_t*/int err;
  public long/*uint64_t*/ faultvaddr;
  public static final int $sizeof_X86_exception_state64_t(){
    return 16;
  }
  @Override public String toString() {
    return "" + "trapno=" + $ushort2uint(trapno) // NOI18N
              + ", cpu=" + $ushort2uint(cpu) // NOI18N
              + ", err=" + err // NOI18N
              + ", faultvaddr=" + faultvaddr; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1587,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1546,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_20x86_thread_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_20x86_thread_state64_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_thread_state64_t /*&*/ x) {
  sys.swapByteOrder(x.rax);
  sys.swapByteOrder(x.rbx);
  sys.swapByteOrder(x.rcx);
  sys.swapByteOrder(x.rdx);
  sys.swapByteOrder(x.rdi);
  sys.swapByteOrder(x.rsi);
  sys.swapByteOrder(x.rbp);
  sys.swapByteOrder(x.rsp);
  sys.swapByteOrder(x.r8);
  sys.swapByteOrder(x.r9);
  sys.swapByteOrder(x.r10);
  sys.swapByteOrder(x.r11);
  sys.swapByteOrder(x.r12);
  sys.swapByteOrder(x.r13);
  sys.swapByteOrder(x.r14);
  sys.swapByteOrder(x.r15);
  sys.swapByteOrder(x.rip);
  sys.swapByteOrder(x.rflags);
  sys.swapByteOrder(x.cs);
  sys.swapByteOrder(x.fs);
  sys.swapByteOrder(x.gs);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1611,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1570,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_19x86_float_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_19x86_float_state64_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_float_state64_t /*&*/ x) {
  sys.swapByteOrder(x.fpu_reserved[0]);
  sys.swapByteOrder(x.fpu_reserved[1]);
  // TODO swap: fp_control_t fpu_fcw;
  // TODO swap: fp_status_t fpu_fsw;
  sys.swapByteOrder(x.fpu_fop);
  sys.swapByteOrder(x.fpu_ip);
  sys.swapByteOrder(x.fpu_cs);
  sys.swapByteOrder(x.fpu_rsrv2);
  sys.swapByteOrder(x.fpu_dp);
  sys.swapByteOrder(x.fpu_ds);
  sys.swapByteOrder(x.fpu_rsrv3);
  sys.swapByteOrder(x.fpu_mxcsr);
  sys.swapByteOrder(x.fpu_mxcsrmask);
  sys.swapByteOrder(x.fpu_reserved1);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1628,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1587,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_23x86_exception_state64_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_23x86_exception_state64_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_exception_state64_t /*&*/ x) {
  sys.swapByteOrder(x.trapno);
  sys.swapByteOrder(x.cpu);
  sys.swapByteOrder(x.err);
  sys.swapByteOrder(x.faultvaddr);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_state_hdr_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1635,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1594,
 FQN="llvm::MachO::x86_state_hdr_t", NM="_ZN4llvm5MachO15x86_state_hdr_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO15x86_state_hdr_tE")
//</editor-fold>
public static class/*struct*/ x86_state_hdr_t {
  public /*uint32_t*/int flavor;
  public /*uint32_t*/int count;

  public static final int $sizeof_x86_state_hdr_t(){
    return 8;
  }

  @Override public String toString() {
    return "" + "flavor=" + flavor // NOI18N
              + ", count=" + count; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_thread_state_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1640,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1599,
 FQN="llvm::MachO::x86_thread_state_t", NM="_ZN4llvm5MachO18x86_thread_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18x86_thread_state_tE")
//</editor-fold>
public static class/*struct*/ x86_thread_state_t {
  public x86_state_hdr_t tsh;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_thread_state_t::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1642,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1601,
   FQN="llvm::MachO::x86_thread_state_t::(anonymous)", NM="_ZN4llvm5MachO18x86_thread_state_tE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18x86_thread_state_tE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public x86_thread_state64_t ts64;
    
    @Override public String toString() {
      return "" + "ts64=" + ts64; // NOI18N
    }
  };
  public Unnamed_union1 uts = new Unnamed_union1();
  
  public static final int $sizeof_X86_thread_state_t(){
    throw new UnsupportedOperationException();
  }

  @Override public String toString() {
    return "" + "tsh=" + tsh // NOI18N
              + ", uts=" + uts; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_float_state_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1647,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1606,
 FQN="llvm::MachO::x86_float_state_t", NM="_ZN4llvm5MachO17x86_float_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17x86_float_state_tE")
//</editor-fold>
public static class/*struct*/ x86_float_state_t {
  public x86_state_hdr_t fsh;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_float_state_t::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1649,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1608,
   FQN="llvm::MachO::x86_float_state_t::(anonymous)", NM="_ZN4llvm5MachO17x86_float_state_tE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO17x86_float_state_tE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public x86_float_state64_t fs64;
    
    @Override public String toString() {
      return "" + "fs64=" + fs64; // NOI18N
    }
  };
  public Unnamed_union1 ufs = new Unnamed_union1();

  public static int $sizeof_X86_float_state_t() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "fsh=" + fsh // NOI18N
              + ", ufs=" + ufs; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_exception_state_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1654,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1613,
 FQN="llvm::MachO::x86_exception_state_t", NM="_ZN4llvm5MachO21x86_exception_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21x86_exception_state_tE")
//</editor-fold>
public static class/*struct*/ x86_exception_state_t {
  public x86_state_hdr_t esh;
  //<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_exception_state_t::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1656,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1615,
   FQN="llvm::MachO::x86_exception_state_t::(anonymous)", NM="_ZN4llvm5MachO21x86_exception_state_tE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO21x86_exception_state_tE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public x86_exception_state64_t es64;
    
    @Override public String toString() {
      return "" + "es64=" + es64; // NOI18N
    }
  };
  public Unnamed_union1 ues = new Unnamed_union1();

  public static int $sizeof_X86_exception_state_t() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override public String toString() {
    return "" + "esh=" + esh // NOI18N
              + ", ues=" + ues; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1661,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1620,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_15x86_state_hdr_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_15x86_state_hdr_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_state_hdr_t /*&*/ x) {
  sys.swapByteOrder(x.flavor);
  sys.swapByteOrder(x.count);
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::X86ThreadFlavors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1666,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1625,
 FQN="llvm::MachO::X86ThreadFlavors", NM="_ZN4llvm5MachO16X86ThreadFlavorsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO16X86ThreadFlavorsE")
//</editor-fold>
public enum X86ThreadFlavors implements Native.NativeUIntEnum {
  x86_THREAD_STATE32(1),
  x86_FLOAT_STATE32(2),
  x86_EXCEPTION_STATE32(3),
  x86_THREAD_STATE64(4),
  x86_FLOAT_STATE64(5),
  x86_EXCEPTION_STATE64(6),
  x86_THREAD_STATE(7),
  x86_FLOAT_STATE(8),
  x86_EXCEPTION_STATE(9),
  x86_DEBUG_STATE32(10),
  x86_DEBUG_STATE64(11),
  x86_DEBUG_STATE(12);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static X86ThreadFlavors valueOf(int val) {
    X86ThreadFlavors out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final X86ThreadFlavors[] VALUES;
    private static final X86ThreadFlavors[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (X86ThreadFlavors kind : X86ThreadFlavors.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new X86ThreadFlavors[min < 0 ? (1-min) : 0];
      VALUES = new X86ThreadFlavors[max >= 0 ? (1+max) : 0];
      for (X86ThreadFlavors kind : X86ThreadFlavors.values()) {
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

  private final /*uint*/int value;
  private X86ThreadFlavors(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1681,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1640,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_18x86_thread_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_18x86_thread_state_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_thread_state_t /*&*/ x) {
  swapStruct(x.tsh);
  if (x.tsh.flavor == X86ThreadFlavors.x86_THREAD_STATE64.getValue()) {
    swapStruct(x.uts.ts64);
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1687,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1646,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_17x86_float_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_17x86_float_state_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_float_state_t /*&*/ x) {
  swapStruct(x.fsh);
  if (x.fsh.flavor == X86ThreadFlavors.x86_FLOAT_STATE64.getValue()) {
    swapStruct(x.ufs.fs64);
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::swapStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1693,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1652,
 FQN="llvm::MachO::swapStruct", NM="_ZN4llvm5MachO10swapStructERNS0_21x86_exception_state_tE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO10swapStructERNS0_21x86_exception_state_tE")
//</editor-fold>
public static /*inline*/ void swapStruct(final x86_exception_state_t /*&*/ x) {
  swapStruct(x.esh);
  if (x.esh.flavor == X86ThreadFlavors.x86_EXCEPTION_STATE64.getValue()) {
    swapStruct(x.ues.es64);
  }
}

//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_THREAD_STATE64_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1699,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1658,
 FQN="llvm::MachO::x86_THREAD_STATE64_COUNT", NM="_ZN4llvm5MachOL24x86_THREAD_STATE64_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL24x86_THREAD_STATE64_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_THREAD_STATE64_COUNT = $div_uint(MachO.x86_thread_state64_t.$sizeof_X86_thread_state64_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_FLOAT_STATE64_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1701,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1660,
 FQN="llvm::MachO::x86_FLOAT_STATE64_COUNT", NM="_ZN4llvm5MachOL23x86_FLOAT_STATE64_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL23x86_FLOAT_STATE64_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_FLOAT_STATE64_COUNT = $div_uint(MachO.x86_float_state64_t.$sizeof_X86_float_state64_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_EXCEPTION_STATE64_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1703,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1662,
 FQN="llvm::MachO::x86_EXCEPTION_STATE64_COUNT", NM="_ZN4llvm5MachOL27x86_EXCEPTION_STATE64_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL27x86_EXCEPTION_STATE64_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_EXCEPTION_STATE64_COUNT = $div_uint(MachO.x86_exception_state64_t.$sizeof_X86_exception_state64_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_THREAD_STATE_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1706,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1665,
 FQN="llvm::MachO::x86_THREAD_STATE_COUNT", NM="_ZN4llvm5MachOL22x86_THREAD_STATE_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL22x86_THREAD_STATE_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_THREAD_STATE_COUNT = $div_uint(MachO.x86_thread_state_t.$sizeof_X86_thread_state_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_FLOAT_STATE_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1708,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1667,
 FQN="llvm::MachO::x86_FLOAT_STATE_COUNT", NM="_ZN4llvm5MachOL21x86_FLOAT_STATE_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL21x86_FLOAT_STATE_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_FLOAT_STATE_COUNT = $div_uint(MachO.x86_float_state_t.$sizeof_X86_float_state_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::x86_EXCEPTION_STATE_COUNT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1710,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", old_line = 1669,
 FQN="llvm::MachO::x86_EXCEPTION_STATE_COUNT", NM="_ZN4llvm5MachOL25x86_EXCEPTION_STATE_COUNTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachOL25x86_EXCEPTION_STATE_COUNTE")
//</editor-fold>
public static /*const*//*uint32_t*/int x86_EXCEPTION_STATE_COUNT = $div_uint(MachO.x86_exception_state_t.$sizeof_X86_exception_state_t(), $sizeof_UInt());
//<editor-fold defaultstate="collapsed" desc="llvm::MachO::macho_load_command">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/MachO.h", line = 1716,
 FQN="llvm::MachO::macho_load_command", NM="_ZN4llvm5MachO18macho_load_commandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/Coverage/CoverageMappingReader.cpp -nm=_ZN4llvm5MachO18macho_load_commandE")
//</editor-fold>
public static class/*union*/ macho_load_command {
  public dyld_info_command dyld_info_command_data;
  public dylib_command dylib_command_data;
  public dylinker_command dylinker_command_data;
  public dysymtab_command dysymtab_command_data;
  public encryption_info_command encryption_info_command_data;
  public encryption_info_command_64 encryption_info_command_64_data;
  public entry_point_command entry_point_command_data;
  public fvmfile_command fvmfile_command_data;
  public fvmlib_command fvmlib_command_data;
  public ident_command ident_command_data;
  public linkedit_data_command linkedit_data_command_data;
  public linker_option_command linker_option_command_data;
  public load_command load_command_data;
  public prebind_cksum_command prebind_cksum_command_data;
  public prebound_dylib_command prebound_dylib_command_data;
  public routines_command routines_command_data;
  public routines_command_64 routines_command_64_data;
  public rpath_command rpath_command_data;
  public segment_command segment_command_data;
  public segment_command_64 segment_command_64_data;
  public source_version_command source_version_command_data;
  public sub_client_command sub_client_command_data;
  public sub_framework_command sub_framework_command_data;
  public sub_library_command sub_library_command_data;
  public sub_umbrella_command sub_umbrella_command_data;
  public symseg_command symseg_command_data;
  public symtab_command symtab_command_data;
  public thread_command thread_command_data;
  public twolevel_hints_command twolevel_hints_command_data;
  public uuid_command uuid_command_data;
  public version_min_command version_min_command_data;
  
  @Override public String toString() {
    return "" + "dyld_info_command_data=" + dyld_info_command_data // NOI18N
              + ", dylib_command_data=" + dylib_command_data // NOI18N
              + ", dylinker_command_data=" + dylinker_command_data // NOI18N
              + ", dysymtab_command_data=" + dysymtab_command_data // NOI18N
              + ", encryption_info_command_data=" + encryption_info_command_data // NOI18N
              + ", encryption_info_command_64_data=" + encryption_info_command_64_data // NOI18N
              + ", entry_point_command_data=" + entry_point_command_data // NOI18N
              + ", fvmfile_command_data=" + fvmfile_command_data // NOI18N
              + ", fvmlib_command_data=" + fvmlib_command_data // NOI18N
              + ", ident_command_data=" + ident_command_data // NOI18N
              + ", linkedit_data_command_data=" + linkedit_data_command_data // NOI18N
              + ", linker_option_command_data=" + linker_option_command_data // NOI18N
              + ", load_command_data=" + load_command_data // NOI18N
              + ", prebind_cksum_command_data=" + prebind_cksum_command_data // NOI18N
              + ", prebound_dylib_command_data=" + prebound_dylib_command_data // NOI18N
              + ", routines_command_data=" + routines_command_data // NOI18N
              + ", routines_command_64_data=" + routines_command_64_data // NOI18N
              + ", rpath_command_data=" + rpath_command_data // NOI18N
              + ", segment_command_data=" + segment_command_data // NOI18N
              + ", segment_command_64_data=" + segment_command_64_data // NOI18N
              + ", source_version_command_data=" + source_version_command_data // NOI18N
              + ", sub_client_command_data=" + sub_client_command_data // NOI18N
              + ", sub_framework_command_data=" + sub_framework_command_data // NOI18N
              + ", sub_library_command_data=" + sub_library_command_data // NOI18N
              + ", sub_umbrella_command_data=" + sub_umbrella_command_data // NOI18N
              + ", symseg_command_data=" + symseg_command_data // NOI18N
              + ", symtab_command_data=" + symtab_command_data // NOI18N
              + ", thread_command_data=" + thread_command_data // NOI18N
              + ", twolevel_hints_command_data=" + twolevel_hints_command_data // NOI18N
              + ", uuid_command_data=" + uuid_command_data // NOI18N
              + ", version_min_command_data=" + version_min_command_data; // NOI18N
  }
}
} // END OF class MachO
