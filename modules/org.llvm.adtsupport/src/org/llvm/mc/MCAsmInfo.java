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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.mc.WinEH.EncodingType;


/// This class is intended to be used as a base class for asm
/// properties and features specific to the target.
//<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 64,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 58,
 FQN="llvm::MCAsmInfo", NM="_ZN4llvm9MCAsmInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfoE")
//</editor-fold>
public class MCAsmInfo implements Destructors.ClassWithDestructor {
/*protected:*/
  //===------------------------------------------------------------------===//
  // Properties to be set by the target writer, used to configure asm printer.
  //
  
  /// Pointer size in bytes.  Default is 4.
  protected /*uint*/int PointerSize;
  
  /// Size of the stack slot reserved for callee-saved registers, in bytes.
  /// Default is same as pointer size.
  protected /*uint*/int CalleeSaveStackSlotSize;
  
  /// True if target is little endian.  Default is true.
  protected boolean IsLittleEndian;
  
  /// True if target stack grow up.  Default is false.
  protected boolean StackGrowsUp;
  
  /// True if this target has the MachO .subsections_via_symbols directive.
  /// Default is false.
  protected boolean HasSubsectionsViaSymbols;
  
  /// True if this is a MachO target that supports the macho-specific .zerofill
  /// directive for emitting BSS Symbols.  Default is false.
  protected boolean HasMachoZeroFillDirective;
  
  /// True if this is a MachO target that supports the macho-specific .tbss
  /// directive for emitting thread local BSS Symbols.  Default is false.
  protected boolean HasMachoTBSSDirective;
  
  /// True if the compiler should emit a ".reference .constructors_used" or
  /// ".reference .destructors_used" directive after the static ctor/dtor
  /// list.  This directive is only emitted in Static relocation model.  Default
  /// is false.
  protected boolean HasStaticCtorDtorReferenceInStaticMode;
  
  /// This is the maximum possible length of an instruction, which is needed to
  /// compute the size of an inline asm.  Defaults to 4.
  protected /*uint*/int MaxInstLength;
  
  /// Every possible instruction length is a multiple of this value.  Factored
  /// out in .debug_frame and .debug_line.  Defaults to 1.
  protected /*uint*/int MinInstAlignment;
  
  /// The '$' token, when not referencing an identifier or constant, refers to
  /// the current PC.  Defaults to false.
  protected boolean DollarIsPC;
  
  /// This string, if specified, is used to separate instructions from each
  /// other when on the same line.  Defaults to ';'
  protected /*const*/char$ptr/*char P*/ SeparatorString;
  
  /// This indicates the comment character used by the assembler.  Defaults to
  /// "#"
  protected /*const*/char$ptr/*char P*/ CommentString;
  
  /// This is appended to emitted labels.  Defaults to ":"
  protected /*const*/char$ptr/*char P*/ LabelSuffix;
  
  // Print the EH begin symbol with an assignment. Defaults to false.
  protected boolean UseAssignmentForEHBegin;
  
  // Do we need to create a local symbol for .size?
  protected boolean NeedsLocalForSize;
  
  /// This prefix is used for globals like constant pool entries that are
  /// completely private to the .s file and should not have names in the .o
  /// file.  Defaults to "L"
  protected /*const*/char$ptr/*char P*/ PrivateGlobalPrefix;
  
  /// This prefix is used for labels for basic blocks. Defaults to the same as
  /// PrivateGlobalPrefix.
  protected /*const*/char$ptr/*char P*/ PrivateLabelPrefix;
  
  /// This prefix is used for symbols that should be passed through the
  /// assembler but be removed by the linker.  This is 'l' on Darwin, currently
  /// used for some ObjC metadata.  The default of "" meast that for this system
  /// a plain private symbol should be used.  Defaults to "".
  protected /*const*/char$ptr/*char P*/ LinkerPrivateGlobalPrefix;
  
  /// If these are nonempty, they contain a directive to emit before and after
  /// an inline assembly statement.  Defaults to "#APP\n", "#NO_APP\n"
  protected /*const*/char$ptr/*char P*/ InlineAsmStart;
  protected /*const*/char$ptr/*char P*/ InlineAsmEnd;
  
  /// These are assembly directives that tells the assembler to interpret the
  /// following instructions differently.  Defaults to ".code16", ".code32",
  /// ".code64".
  protected /*const*/char$ptr/*char P*/ Code16Directive;
  protected /*const*/char$ptr/*char P*/ Code32Directive;
  protected /*const*/char$ptr/*char P*/ Code64Directive;
  
  /// Which dialect of an assembler variant to use.  Defaults to 0
  protected /*uint*/int AssemblerDialect;
  
  /// This is true if the assembler allows @ characters in symbol names.
  /// Defaults to false.
  protected boolean AllowAtInName;
  
  /// If this is true, symbol names with invalid characters will be printed in
  /// quotes.
  protected boolean SupportsQuotedNames;
  
  /// This is true if data region markers should be printed as
  /// ".data_region/.end_data_region" directives. If false, use "$d/$a" labels
  /// instead.
  protected boolean UseDataRegionDirectives;
  
  //===--- Data Emission Directives -------------------------------------===//
  
  /// This should be set to the directive used to get some number of zero bytes
  /// emitted to the current section.  Common cases are "\t.zero\t" and
  /// "\t.space\t".  If this is set to null, the Data*bitsDirective's will be
  /// used to emit zero bytes.  Defaults to "\t.zero\t"
  protected /*const*/char$ptr/*char P*/ ZeroDirective;
  
  /// This directive allows emission of an ascii string with the standard C
  /// escape characters embedded into it.  Defaults to "\t.ascii\t"
  protected /*const*/char$ptr/*char P*/ AsciiDirective;
  
  /// If not null, this allows for special handling of zero terminated strings
  /// on this target.  This is commonly supported as ".asciz".  If a target
  /// doesn't support this, it can be set to null.  Defaults to "\t.asciz\t"
  protected /*const*/char$ptr/*char P*/ AscizDirective;
  
  /// These directives are used to output some unit of integer data to the
  /// current section.  If a data directive is set to null, smaller data
  /// directives will be used to emit the large sizes.  Defaults to "\t.byte\t",
  /// "\t.short\t", "\t.long\t", "\t.quad\t"
  protected /*const*/char$ptr/*char P*/ Data8bitsDirective;
  protected /*const*/char$ptr/*char P*/ Data16bitsDirective;
  protected /*const*/char$ptr/*char P*/ Data32bitsDirective;
  protected /*const*/char$ptr/*char P*/ Data64bitsDirective;
  
  /// If non-null, a directive that is used to emit a word which should be
  /// relocated as a 64-bit GP-relative offset, e.g. .gpdword on Mips.  Defaults
  /// to NULL.
  protected /*const*/char$ptr/*char P*/ GPRel64Directive;
  
  /// If non-null, a directive that is used to emit a word which should be
  /// relocated as a 32-bit GP-relative offset, e.g. .gpword on Mips or .gprel32
  /// on Alpha.  Defaults to NULL.
  protected /*const*/char$ptr/*char P*/ GPRel32Directive;
  
  /// This is true if this target uses "Sun Style" syntax for section switching
  /// ("#alloc,#write" etc) instead of the normal ELF syntax (,"a,w") in
  /// .section directives.  Defaults to false.
  protected boolean SunStyleELFSectionSwitchSyntax;
  
  /// This is true if this target uses ELF '.section' directive before the
  /// '.bss' one. It's used for PPC/Linux which doesn't support the '.bss'
  /// directive only.  Defaults to false.
  protected boolean UsesELFSectionDirectiveForBSS;
  
  protected boolean NeedsDwarfSectionOffsetDirective;
  
  //===--- Alignment Information ----------------------------------------===//
  
  /// If this is true (the default) then the asmprinter emits ".align N"
  /// directives, where N is the number of bytes to align to.  Otherwise, it
  /// emits ".align log2(N)", e.g. 3 to align to an 8 byte boundary.  Defaults
  /// to true.
  protected boolean AlignmentIsInBytes;
  
  /// If non-zero, this is used to fill the executable space created as the
  /// result of a alignment directive.  Defaults to 0
  protected /*uint*/int TextAlignFillValue;
  
  //===--- Global Variable Emission Directives --------------------------===//
  
  /// This is the directive used to declare a global entity. Defaults to
  /// ".globl".
  protected /*const*/char$ptr/*char P*/ GlobalDirective;
  
  /// True if the expression
  ///   .long f - g
  /// uses a relocation but it can be suppressed by writing
  ///   a = f - g
  ///   .long a
  protected boolean SetDirectiveSuppressesReloc;
  
  /// False if the assembler requires that we use
  /// \code
  ///   Lc = a - b
  ///   .long Lc
  /// \endcode
  //
  /// instead of
  //
  /// \code
  ///   .long a - b
  /// \endcode
  ///
  ///  Defaults to true.
  protected boolean HasAggressiveSymbolFolding;
  
  /// True is .comm's and .lcomms optional alignment is to be specified in bytes
  /// instead of log2(n).  Defaults to true.
  protected boolean COMMDirectiveAlignmentIsInBytes;
  
  /// Describes if the .lcomm directive for the target supports an alignment
  /// argument and how it is interpreted.  Defaults to NoAlignment.
  protected LCOMM.LCOMMType LCOMMDirectiveAlignmentType;
  
  // True if the target allows .align directives on functions. This is true for
  // most targets, so defaults to true.
  protected boolean HasFunctionAlignment;
  
  /// True if the target has .type and .size directives, this is true for most
  /// ELF targets.  Defaults to true.
  protected boolean HasDotTypeDotSizeDirective;
  
  /// True if the target has a single parameter .file directive, this is true
  /// for ELF targets.  Defaults to true.
  protected boolean HasSingleParameterDotFile;
  
  /// True if the target has a .ident directive, this is true for ELF targets.
  /// Defaults to false.
  protected boolean HasIdentDirective;
  
  /// True if this target supports the MachO .no_dead_strip directive.  Defaults
  /// to false.
  protected boolean HasNoDeadStrip;
  
  /// True if this target supports the MachO .alt_entry directive.  Defaults to
  /// false.
  protected boolean HasAltEntry;
  
  /// Used to declare a global as being a weak symbol. Defaults to ".weak".
  protected /*const*/char$ptr/*char P*/ WeakDirective;
  
  /// This directive, if non-null, is used to declare a global as being a weak
  /// undefined symbol.  Defaults to NULL.
  protected /*const*/char$ptr/*char P*/ WeakRefDirective;
  
  /// True if we have a directive to declare a global as being a weak defined
  /// symbol.  Defaults to false.
  protected boolean HasWeakDefDirective;
  
  /// True if we have a directive to declare a global as being a weak defined
  /// symbol that can be hidden (unexported).  Defaults to false.
  protected boolean HasWeakDefCanBeHiddenDirective;
  
  /// True if we have a .linkonce directive.  This is used on cygwin/mingw.
  /// Defaults to false.
  protected boolean HasLinkOnceDirective;
  
  /// This attribute, if not MCSA_Invalid, is used to declare a symbol as having
  /// hidden visibility.  Defaults to MCSA_Hidden.
  protected MCSymbolAttr HiddenVisibilityAttr;
  
  /// This attribute, if not MCSA_Invalid, is used to declare an undefined
  /// symbol as having hidden visibility. Defaults to MCSA_Hidden.
  protected MCSymbolAttr HiddenDeclarationVisibilityAttr;
  
  /// This attribute, if not MCSA_Invalid, is used to declare a symbol as having
  /// protected visibility.  Defaults to MCSA_Protected
  protected MCSymbolAttr ProtectedVisibilityAttr;
  
  //===--- Dwarf Emission Directives -----------------------------------===//
  
  /// True if target supports emission of debugging information.  Defaults to
  /// false.
  protected boolean SupportsDebugInformation;
  
  /// Exception handling format for the target.  Defaults to None.
  protected ExceptionHandling ExceptionsType;
  
  /// Windows exception handling data (.pdata) encoding.  Defaults to Invalid.
  protected EncodingType WinEHEncodingType;
  
  /// True if Dwarf2 output generally uses relocations for references to other
  /// .debug_* sections.
  protected boolean DwarfUsesRelocationsAcrossSections;
  
  /// True if DWARF FDE symbol reference relocations should be replaced by an
  /// absolute difference.
  protected boolean DwarfFDESymbolsUseAbsDiff;
  
  /// True if dwarf register numbers are printed instead of symbolic register
  /// names in .cfi_* directives.  Defaults to false.
  protected boolean DwarfRegNumForCFI;
  
  /// True if target uses parens to indicate the symbol variant instead of @.
  /// For example, foo(plt) instead of foo@plt.  Defaults to false.
  protected boolean UseParensForSymbolVariant;
  
  //===--- Prologue State ----------------------------------------------===//
  protected std.vector<MCCFIInstruction> InitialFrameState;
  
  //===--- Integrated Assembler Information ----------------------------===//
  
  /// Should we use the integrated assembler?
  /// The integrated assembler should be enabled by default (by the
  /// constructors) when failing to parse a valid piece of assembly (inline
  /// or otherwise) is considered a bug. It may then be overridden after
  /// construction (see LLVMTargetMachine::initAsmInfo()).
  protected boolean UseIntegratedAssembler;
  
  /// Preserve Comments in assembly
  protected boolean PreserveAsmComments;
  
  /// Compress DWARF debug sections. Defaults to no compression.
  protected DebugCompressionType CompressDebugSections;
  
  /// True if the integrated assembler should interpret 'a >> b' constant
  /// expressions as logical rather than arithmetic.
  protected boolean UseLogicalShr;
  
  // If true, emit GOTPCRELX/REX_GOTPCRELX instead of GOTPCREL, on
  // X86_64 ELF.
  protected boolean RelaxELFRelocations/* = true*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::MCAsmInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 25,
   FQN="llvm::MCAsmInfo::MCAsmInfo", NM="_ZN4llvm9MCAsmInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfoC1Ev")
  //</editor-fold>
  public MCAsmInfo() {
    /* : InitialFrameState(), RelaxELFRelocations(true)*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::~MCAsmInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 113,
   FQN="llvm::MCAsmInfo::~MCAsmInfo", NM="_ZN4llvm9MCAsmInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the pointer size in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getPointerSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 384,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 367,
   FQN="llvm::MCAsmInfo::getPointerSize", NM="_ZNK4llvm9MCAsmInfo14getPointerSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo14getPointerSizeEv")
  //</editor-fold>
  public /*uint*/int getPointerSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get the callee-saved register stack slot
  /// size in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCalleeSaveStackSlotSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 388,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 371,
   FQN="llvm::MCAsmInfo::getCalleeSaveStackSlotSize", NM="_ZNK4llvm9MCAsmInfo26getCalleeSaveStackSlotSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo26getCalleeSaveStackSlotSizeEv")
  //</editor-fold>
  public /*uint*/int getCalleeSaveStackSlotSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// True if the target is little endian.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 393,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 376,
   FQN="llvm::MCAsmInfo::isLittleEndian", NM="_ZNK4llvm9MCAsmInfo14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo14isLittleEndianEv")
  //</editor-fold>
  public boolean isLittleEndian() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// True if target stack grow up.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::isStackGrowthDirectionUp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 396,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 379,
   FQN="llvm::MCAsmInfo::isStackGrowthDirectionUp", NM="_ZNK4llvm9MCAsmInfo24isStackGrowthDirectionUpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo24isStackGrowthDirectionUpEv")
  //</editor-fold>
  public boolean isStackGrowthDirectionUp() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasSubsectionsViaSymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 398,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 381,
   FQN="llvm::MCAsmInfo::hasSubsectionsViaSymbols", NM="_ZNK4llvm9MCAsmInfo24hasSubsectionsViaSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo24hasSubsectionsViaSymbolsEv")
  //</editor-fold>
  public boolean hasSubsectionsViaSymbols() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Data directive accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getData8bitsDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 402,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 385,
   FQN="llvm::MCAsmInfo::getData8bitsDirective", NM="_ZNK4llvm9MCAsmInfo21getData8bitsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21getData8bitsDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getData8bitsDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getData16bitsDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 386,
   FQN="llvm::MCAsmInfo::getData16bitsDirective", NM="_ZNK4llvm9MCAsmInfo22getData16bitsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo22getData16bitsDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getData16bitsDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getData32bitsDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 387,
   FQN="llvm::MCAsmInfo::getData32bitsDirective", NM="_ZNK4llvm9MCAsmInfo22getData32bitsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo22getData32bitsDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getData32bitsDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getData64bitsDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 388,
   FQN="llvm::MCAsmInfo::getData64bitsDirective", NM="_ZNK4llvm9MCAsmInfo22getData64bitsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo22getData64bitsDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getData64bitsDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getGPRel64Directive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 406,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 389,
   FQN="llvm::MCAsmInfo::getGPRel64Directive", NM="_ZNK4llvm9MCAsmInfo19getGPRel64DirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getGPRel64DirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getGPRel64Directive() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getGPRel32Directive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 407,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 390,
   FQN="llvm::MCAsmInfo::getGPRel32Directive", NM="_ZNK4llvm9MCAsmInfo19getGPRel32DirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getGPRel32DirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getGPRel32Directive() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Targets can implement this method to specify a section to switch to if the
  /// translation unit doesn't have any trampolines that require an executable
  /// stack.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getNonexecutableStackSection">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 412,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 395,
   FQN="llvm::MCAsmInfo::getNonexecutableStackSection", NM="_ZNK4llvm9MCAsmInfo28getNonexecutableStackSectionERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo28getNonexecutableStackSectionERNS_9MCContextE")
  //</editor-fold>
  public /*virtual*/ MCSection /*P*/ getNonexecutableStackSection(MCContext /*&*/ Ctx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief True if the section is atomized using the symbols in it.
  /// This is false if the section is not atomized at all (most ELF sections) or
  /// if it is atomized based on its contents (MachO' __TEXT,__cstring for
  /// example).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::isSectionAtomizableBySymbols">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 118,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 116,
   FQN="llvm::MCAsmInfo::isSectionAtomizableBySymbols", NM="_ZNK4llvm9MCAsmInfo28isSectionAtomizableBySymbolsERKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo28isSectionAtomizableBySymbolsERKNS_9MCSectionE")
  //</editor-fold>
  public boolean isSectionAtomizableBySymbols(/*const*/ MCSection /*&*/ Section) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getExprForPersonalitySymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 122,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 120,
   FQN="llvm::MCAsmInfo::getExprForPersonalitySymbol", NM="_ZNK4llvm9MCAsmInfo27getExprForPersonalitySymbolEPKNS_8MCSymbolEjRNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo27getExprForPersonalitySymbolEPKNS_8MCSymbolEjRNS_10MCStreamerE")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getExprForPersonalitySymbol(/*const*/ MCSymbol /*P*/ Sym, 
                             /*uint*/int Encoding, 
                             MCStreamer /*&*/ Streamer) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getExprForFDESymbol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 129,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 127,
   FQN="llvm::MCAsmInfo::getExprForFDESymbol", NM="_ZNK4llvm9MCAsmInfo19getExprForFDESymbolEPKNS_8MCSymbolEjRNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getExprForFDESymbolEPKNS_8MCSymbolEjRNS_10MCStreamerE")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getExprForFDESymbol(/*const*/ MCSymbol /*P*/ Sym, 
                     /*uint*/int Encoding, 
                     MCStreamer /*&*/ Streamer) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the identifier \p Name does not need quotes to be
  /// syntactically correct.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::isValidUnquotedName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 149,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 147,
   FQN="llvm::MCAsmInfo::isValidUnquotedName", NM="_ZNK4llvm9MCAsmInfo19isValidUnquotedNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19isValidUnquotedNameENS_9StringRefE")
  //</editor-fold>
  public boolean isValidUnquotedName(StringRef Name) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if the .section directive should be omitted when
  /// emitting \p SectionName.  For example:
  ///
  /// shouldOmitSectionDirective(".text")
  ///
  /// returns false => .section .text,#alloc,#execinstr
  /// returns true  => .text
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::shouldOmitSectionDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", line = 163,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp", old_line = 161,
   FQN="llvm::MCAsmInfo::shouldOmitSectionDirective", NM="_ZNK4llvm9MCAsmInfo26shouldOmitSectionDirectiveENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo26shouldOmitSectionDirectiveENS_9StringRefE")
  //</editor-fold>
  public boolean shouldOmitSectionDirective(StringRef SectionName) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::usesSunStyleELFSectionSwitchSyntax">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 443,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 426,
   FQN="llvm::MCAsmInfo::usesSunStyleELFSectionSwitchSyntax", NM="_ZNK4llvm9MCAsmInfo34usesSunStyleELFSectionSwitchSyntaxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo34usesSunStyleELFSectionSwitchSyntaxEv")
  //</editor-fold>
  public boolean usesSunStyleELFSectionSwitchSyntax() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::usesELFSectionDirectiveForBSS">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 447,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 430,
   FQN="llvm::MCAsmInfo::usesELFSectionDirectiveForBSS", NM="_ZNK4llvm9MCAsmInfo29usesELFSectionDirectiveForBSSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo29usesELFSectionDirectiveForBSSEv")
  //</editor-fold>
  public boolean usesELFSectionDirectiveForBSS() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::needsDwarfSectionOffsetDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 451,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 434,
   FQN="llvm::MCAsmInfo::needsDwarfSectionOffsetDirective", NM="_ZNK4llvm9MCAsmInfo32needsDwarfSectionOffsetDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo32needsDwarfSectionOffsetDirectiveEv")
  //</editor-fold>
  public boolean needsDwarfSectionOffsetDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasMachoZeroFillDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 457,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 440,
   FQN="llvm::MCAsmInfo::hasMachoZeroFillDirective", NM="_ZNK4llvm9MCAsmInfo25hasMachoZeroFillDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo25hasMachoZeroFillDirectiveEv")
  //</editor-fold>
  public boolean hasMachoZeroFillDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasMachoTBSSDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 458,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 441,
   FQN="llvm::MCAsmInfo::hasMachoTBSSDirective", NM="_ZNK4llvm9MCAsmInfo21hasMachoTBSSDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21hasMachoTBSSDirectiveEv")
  //</editor-fold>
  public boolean hasMachoTBSSDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasStaticCtorDtorReferenceInStaticMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 459,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 442,
   FQN="llvm::MCAsmInfo::hasStaticCtorDtorReferenceInStaticMode", NM="_ZNK4llvm9MCAsmInfo38hasStaticCtorDtorReferenceInStaticModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo38hasStaticCtorDtorReferenceInStaticModeEv")
  //</editor-fold>
  public boolean hasStaticCtorDtorReferenceInStaticMode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getMaxInstLength">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 462,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 445,
   FQN="llvm::MCAsmInfo::getMaxInstLength", NM="_ZNK4llvm9MCAsmInfo16getMaxInstLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo16getMaxInstLengthEv")
  //</editor-fold>
  public /*uint*/int getMaxInstLength() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getMinInstAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 463,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 446,
   FQN="llvm::MCAsmInfo::getMinInstAlignment", NM="_ZNK4llvm9MCAsmInfo19getMinInstAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getMinInstAlignmentEv")
  //</editor-fold>
  public /*uint*/int getMinInstAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getDollarIsPC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 447,
   FQN="llvm::MCAsmInfo::getDollarIsPC", NM="_ZNK4llvm9MCAsmInfo13getDollarIsPCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo13getDollarIsPCEv")
  //</editor-fold>
  public boolean getDollarIsPC() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getSeparatorString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 465,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 448,
   FQN="llvm::MCAsmInfo::getSeparatorString", NM="_ZNK4llvm9MCAsmInfo18getSeparatorStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo18getSeparatorStringEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSeparatorString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// This indicates the column (zero-based) at which asm comments should be
  /// printed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCommentColumn">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 469,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 452,
   FQN="llvm::MCAsmInfo::getCommentColumn", NM="_ZNK4llvm9MCAsmInfo16getCommentColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo16getCommentColumnEv")
  //</editor-fold>
  public /*uint*/int getCommentColumn() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCommentString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 454,
   FQN="llvm::MCAsmInfo::getCommentString", NM="_ZNK4llvm9MCAsmInfo16getCommentStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo16getCommentStringEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCommentString() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getLabelSuffix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 455,
   FQN="llvm::MCAsmInfo::getLabelSuffix", NM="_ZNK4llvm9MCAsmInfo14getLabelSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo14getLabelSuffixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getLabelSuffix() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::useAssignmentForEHBegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 457,
   FQN="llvm::MCAsmInfo::useAssignmentForEHBegin", NM="_ZNK4llvm9MCAsmInfo23useAssignmentForEHBeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo23useAssignmentForEHBeginEv")
  //</editor-fold>
  public boolean useAssignmentForEHBegin() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::needsLocalForSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 475,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 458,
   FQN="llvm::MCAsmInfo::needsLocalForSize", NM="_ZNK4llvm9MCAsmInfo17needsLocalForSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17needsLocalForSizeEv")
  //</editor-fold>
  public boolean needsLocalForSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 459,
   FQN="llvm::MCAsmInfo::getPrivateGlobalPrefix", NM="_ZNK4llvm9MCAsmInfo22getPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo22getPrivateGlobalPrefixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPrivateGlobalPrefix() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getPrivateLabelPrefix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 460,
   FQN="llvm::MCAsmInfo::getPrivateLabelPrefix", NM="_ZNK4llvm9MCAsmInfo21getPrivateLabelPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21getPrivateLabelPrefixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPrivateLabelPrefix() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasLinkerPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 478,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 461,
   FQN="llvm::MCAsmInfo::hasLinkerPrivateGlobalPrefix", NM="_ZNK4llvm9MCAsmInfo28hasLinkerPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo28hasLinkerPrivateGlobalPrefixEv")
  //</editor-fold>
  public boolean hasLinkerPrivateGlobalPrefix() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getLinkerPrivateGlobalPrefix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 481,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 464,
   FQN="llvm::MCAsmInfo::getLinkerPrivateGlobalPrefix", NM="_ZNK4llvm9MCAsmInfo28getLinkerPrivateGlobalPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo28getLinkerPrivateGlobalPrefixEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getLinkerPrivateGlobalPrefix() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getInlineAsmStart">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 469,
   FQN="llvm::MCAsmInfo::getInlineAsmStart", NM="_ZNK4llvm9MCAsmInfo17getInlineAsmStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17getInlineAsmStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getInlineAsmStart() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getInlineAsmEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 487,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 470,
   FQN="llvm::MCAsmInfo::getInlineAsmEnd", NM="_ZNK4llvm9MCAsmInfo15getInlineAsmEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo15getInlineAsmEndEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getInlineAsmEnd() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCode16Directive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 488,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 471,
   FQN="llvm::MCAsmInfo::getCode16Directive", NM="_ZNK4llvm9MCAsmInfo18getCode16DirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo18getCode16DirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCode16Directive() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCode32Directive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 489,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 472,
   FQN="llvm::MCAsmInfo::getCode32Directive", NM="_ZNK4llvm9MCAsmInfo18getCode32DirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo18getCode32DirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCode32Directive() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCode64Directive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 473,
   FQN="llvm::MCAsmInfo::getCode64Directive", NM="_ZNK4llvm9MCAsmInfo18getCode64DirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo18getCode64DirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCode64Directive() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getAssemblerDialect">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 491,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 474,
   FQN="llvm::MCAsmInfo::getAssemblerDialect", NM="_ZNK4llvm9MCAsmInfo19getAssemblerDialectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getAssemblerDialectEv")
  //</editor-fold>
  public /*uint*/int getAssemblerDialect() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesAllowAtInName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 475,
   FQN="llvm::MCAsmInfo::doesAllowAtInName", NM="_ZNK4llvm9MCAsmInfo17doesAllowAtInNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17doesAllowAtInNameEv")
  //</editor-fold>
  public boolean doesAllowAtInName() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::supportsNameQuoting">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 476,
   FQN="llvm::MCAsmInfo::supportsNameQuoting", NM="_ZNK4llvm9MCAsmInfo19supportsNameQuotingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19supportsNameQuotingEv")
  //</editor-fold>
  public boolean supportsNameQuoting() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesSupportDataRegionDirectives">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 494,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 477,
   FQN="llvm::MCAsmInfo::doesSupportDataRegionDirectives", NM="_ZNK4llvm9MCAsmInfo31doesSupportDataRegionDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo31doesSupportDataRegionDirectivesEv")
  //</editor-fold>
  public boolean doesSupportDataRegionDirectives() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getZeroDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 497,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 480,
   FQN="llvm::MCAsmInfo::getZeroDirective", NM="_ZNK4llvm9MCAsmInfo16getZeroDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo16getZeroDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getZeroDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getAsciiDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 498,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 481,
   FQN="llvm::MCAsmInfo::getAsciiDirective", NM="_ZNK4llvm9MCAsmInfo17getAsciiDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17getAsciiDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getAsciiDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getAscizDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 499,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 482,
   FQN="llvm::MCAsmInfo::getAscizDirective", NM="_ZNK4llvm9MCAsmInfo17getAscizDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17getAscizDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getAscizDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getAlignmentIsInBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 500,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 483,
   FQN="llvm::MCAsmInfo::getAlignmentIsInBytes", NM="_ZNK4llvm9MCAsmInfo21getAlignmentIsInBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21getAlignmentIsInBytesEv")
  //</editor-fold>
  public boolean getAlignmentIsInBytes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getTextAlignFillValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 484,
   FQN="llvm::MCAsmInfo::getTextAlignFillValue", NM="_ZNK4llvm9MCAsmInfo21getTextAlignFillValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21getTextAlignFillValueEv")
  //</editor-fold>
  public /*uint*/int getTextAlignFillValue() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getGlobalDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 502,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 485,
   FQN="llvm::MCAsmInfo::getGlobalDirective", NM="_ZNK4llvm9MCAsmInfo18getGlobalDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo18getGlobalDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getGlobalDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesSetDirectiveSuppressReloc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 503,
   FQN="llvm::MCAsmInfo::doesSetDirectiveSuppressReloc", NM="_ZNK4llvm9MCAsmInfo29doesSetDirectiveSuppressRelocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo29doesSetDirectiveSuppressRelocEv")
  //</editor-fold>
  public boolean doesSetDirectiveSuppressReloc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasAggressiveSymbolFolding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 489,
   FQN="llvm::MCAsmInfo::hasAggressiveSymbolFolding", NM="_ZNK4llvm9MCAsmInfo26hasAggressiveSymbolFoldingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo26hasAggressiveSymbolFoldingEv")
  //</editor-fold>
  public boolean hasAggressiveSymbolFolding() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getCOMMDirectiveAlignmentIsInBytes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 507,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 490,
   FQN="llvm::MCAsmInfo::getCOMMDirectiveAlignmentIsInBytes", NM="_ZNK4llvm9MCAsmInfo34getCOMMDirectiveAlignmentIsInBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo34getCOMMDirectiveAlignmentIsInBytesEv")
  //</editor-fold>
  public boolean getCOMMDirectiveAlignmentIsInBytes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getLCOMMDirectiveAlignmentType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 510,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 493,
   FQN="llvm::MCAsmInfo::getLCOMMDirectiveAlignmentType", NM="_ZNK4llvm9MCAsmInfo30getLCOMMDirectiveAlignmentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo30getLCOMMDirectiveAlignmentTypeEv")
  //</editor-fold>
  public LCOMM.LCOMMType getLCOMMDirectiveAlignmentType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasFunctionAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 513,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 496,
   FQN="llvm::MCAsmInfo::hasFunctionAlignment", NM="_ZNK4llvm9MCAsmInfo20hasFunctionAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo20hasFunctionAlignmentEv")
  //</editor-fold>
  public boolean hasFunctionAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasDotTypeDotSizeDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 497,
   FQN="llvm::MCAsmInfo::hasDotTypeDotSizeDirective", NM="_ZNK4llvm9MCAsmInfo26hasDotTypeDotSizeDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo26hasDotTypeDotSizeDirectiveEv")
  //</editor-fold>
  public boolean hasDotTypeDotSizeDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasSingleParameterDotFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 515,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 498,
   FQN="llvm::MCAsmInfo::hasSingleParameterDotFile", NM="_ZNK4llvm9MCAsmInfo25hasSingleParameterDotFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo25hasSingleParameterDotFileEv")
  //</editor-fold>
  public boolean hasSingleParameterDotFile() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasIdentDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 516,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 499,
   FQN="llvm::MCAsmInfo::hasIdentDirective", NM="_ZNK4llvm9MCAsmInfo17hasIdentDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo17hasIdentDirectiveEv")
  //</editor-fold>
  public boolean hasIdentDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasNoDeadStrip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 517,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 500,
   FQN="llvm::MCAsmInfo::hasNoDeadStrip", NM="_ZNK4llvm9MCAsmInfo14hasNoDeadStripEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo14hasNoDeadStripEv")
  //</editor-fold>
  public boolean hasNoDeadStrip() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasAltEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 518,
   FQN="llvm::MCAsmInfo::hasAltEntry", NM="_ZNK4llvm9MCAsmInfo11hasAltEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo11hasAltEntryEv")
  //</editor-fold>
  public boolean hasAltEntry() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getWeakDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 519,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 501,
   FQN="llvm::MCAsmInfo::getWeakDirective", NM="_ZNK4llvm9MCAsmInfo16getWeakDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo16getWeakDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getWeakDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getWeakRefDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 520,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 502,
   FQN="llvm::MCAsmInfo::getWeakRefDirective", NM="_ZNK4llvm9MCAsmInfo19getWeakRefDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19getWeakRefDirectiveEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getWeakRefDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasWeakDefDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 521,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 503,
   FQN="llvm::MCAsmInfo::hasWeakDefDirective", NM="_ZNK4llvm9MCAsmInfo19hasWeakDefDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19hasWeakDefDirectiveEv")
  //</editor-fold>
  public boolean hasWeakDefDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasWeakDefCanBeHiddenDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 522,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 504,
   FQN="llvm::MCAsmInfo::hasWeakDefCanBeHiddenDirective", NM="_ZNK4llvm9MCAsmInfo30hasWeakDefCanBeHiddenDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo30hasWeakDefCanBeHiddenDirectiveEv")
  //</editor-fold>
  public boolean hasWeakDefCanBeHiddenDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::hasLinkOnceDirective">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 525,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 507,
   FQN="llvm::MCAsmInfo::hasLinkOnceDirective", NM="_ZNK4llvm9MCAsmInfo20hasLinkOnceDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo20hasLinkOnceDirectiveEv")
  //</editor-fold>
  public boolean hasLinkOnceDirective() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getHiddenVisibilityAttr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 527,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 509,
   FQN="llvm::MCAsmInfo::getHiddenVisibilityAttr", NM="_ZNK4llvm9MCAsmInfo23getHiddenVisibilityAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo23getHiddenVisibilityAttrEv")
  //</editor-fold>
  public MCSymbolAttr getHiddenVisibilityAttr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getHiddenDeclarationVisibilityAttr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 528,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 510,
   FQN="llvm::MCAsmInfo::getHiddenDeclarationVisibilityAttr", NM="_ZNK4llvm9MCAsmInfo34getHiddenDeclarationVisibilityAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo34getHiddenDeclarationVisibilityAttrEv")
  //</editor-fold>
  public MCSymbolAttr getHiddenDeclarationVisibilityAttr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getProtectedVisibilityAttr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 531,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 513,
   FQN="llvm::MCAsmInfo::getProtectedVisibilityAttr", NM="_ZNK4llvm9MCAsmInfo26getProtectedVisibilityAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo26getProtectedVisibilityAttrEv")
  //</editor-fold>
  public MCSymbolAttr getProtectedVisibilityAttr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesSupportDebugInformation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 534,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 516,
   FQN="llvm::MCAsmInfo::doesSupportDebugInformation", NM="_ZNK4llvm9MCAsmInfo27doesSupportDebugInformationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo27doesSupportDebugInformationEv")
  //</editor-fold>
  public boolean doesSupportDebugInformation() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesSupportExceptionHandling">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 535,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 517,
   FQN="llvm::MCAsmInfo::doesSupportExceptionHandling", NM="_ZNK4llvm9MCAsmInfo28doesSupportExceptionHandlingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo28doesSupportExceptionHandlingEv")
  //</editor-fold>
  public boolean doesSupportExceptionHandling() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getExceptionHandlingType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 538,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 520,
   FQN="llvm::MCAsmInfo::getExceptionHandlingType", NM="_ZNK4llvm9MCAsmInfo24getExceptionHandlingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo24getExceptionHandlingTypeEv")
  //</editor-fold>
  public ExceptionHandling getExceptionHandlingType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getWinEHEncodingType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 539,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 521,
   FQN="llvm::MCAsmInfo::getWinEHEncodingType", NM="_ZNK4llvm9MCAsmInfo20getWinEHEncodingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo20getWinEHEncodingTypeEv")
  //</editor-fold>
  public EncodingType getWinEHEncodingType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::setExceptionsType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 541,
   FQN="llvm::MCAsmInfo::setExceptionsType", NM="_ZN4llvm9MCAsmInfo17setExceptionsTypeENS_17ExceptionHandlingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo17setExceptionsTypeENS_17ExceptionHandlingE")
  //</editor-fold>
  public void setExceptionsType(ExceptionHandling EH) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if the exception handling method for the platform uses call
  /// frame information to unwind.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::usesCFIForEH">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 547,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 525,
   FQN="llvm::MCAsmInfo::usesCFIForEH", NM="_ZNK4llvm9MCAsmInfo12usesCFIForEHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo12usesCFIForEHEv")
  //</editor-fold>
  public boolean usesCFIForEH() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::usesWindowsCFI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 552,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 530,
   FQN="llvm::MCAsmInfo::usesWindowsCFI", NM="_ZNK4llvm9MCAsmInfo14usesWindowsCFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo14usesWindowsCFIEv")
  //</editor-fold>
  public boolean usesWindowsCFI() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doesDwarfUseRelocationsAcrossSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 558,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 536,
   FQN="llvm::MCAsmInfo::doesDwarfUseRelocationsAcrossSections", NM="_ZNK4llvm9MCAsmInfo37doesDwarfUseRelocationsAcrossSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo37doesDwarfUseRelocationsAcrossSectionsEv")
  //</editor-fold>
  public boolean doesDwarfUseRelocationsAcrossSections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::doDwarfFDESymbolsUseAbsDiff">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 561,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 539,
   FQN="llvm::MCAsmInfo::doDwarfFDESymbolsUseAbsDiff", NM="_ZNK4llvm9MCAsmInfo27doDwarfFDESymbolsUseAbsDiffEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo27doDwarfFDESymbolsUseAbsDiffEv")
  //</editor-fold>
  public boolean doDwarfFDESymbolsUseAbsDiff() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::useDwarfRegNumForCFI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 562,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 540,
   FQN="llvm::MCAsmInfo::useDwarfRegNumForCFI", NM="_ZNK4llvm9MCAsmInfo20useDwarfRegNumForCFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo20useDwarfRegNumForCFIEv")
  //</editor-fold>
  public boolean useDwarfRegNumForCFI() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::useParensForSymbolVariant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 563,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 541,
   FQN="llvm::MCAsmInfo::useParensForSymbolVariant", NM="_ZNK4llvm9MCAsmInfo25useParensForSymbolVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo25useParensForSymbolVariantEv")
  //</editor-fold>
  public boolean useParensForSymbolVariant() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::addInitialFrameState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 565,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 543,
   FQN="llvm::MCAsmInfo::addInitialFrameState", NM="_ZN4llvm9MCAsmInfo20addInitialFrameStateERKNS_16MCCFIInstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo20addInitialFrameStateERKNS_16MCCFIInstructionE")
  //</editor-fold>
  public void addInitialFrameState(/*const*/ MCCFIInstruction /*&*/ Inst) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::getInitialFrameState">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 569,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 547,
   FQN="llvm::MCAsmInfo::getInitialFrameState", NM="_ZNK4llvm9MCAsmInfo20getInitialFrameStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo20getInitialFrameStateEv")
  //</editor-fold>
  public /*const*/std.vector<MCCFIInstruction> /*&*/ getInitialFrameState() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if assembly (inline or otherwise) should be parsed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::useIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 574,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 552,
   FQN="llvm::MCAsmInfo::useIntegratedAssembler", NM="_ZNK4llvm9MCAsmInfo22useIntegratedAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo22useIntegratedAssemblerEv")
  //</editor-fold>
  public boolean useIntegratedAssembler() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Set whether assembly (inline or otherwise) should be parsed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::setUseIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 577,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 555,
   FQN="llvm::MCAsmInfo::setUseIntegratedAssembler", NM="_ZN4llvm9MCAsmInfo25setUseIntegratedAssemblerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo25setUseIntegratedAssemblerEb")
  //</editor-fold>
  public /*virtual*/ void setUseIntegratedAssembler(boolean Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return true if assembly (inline or otherwise) should be parsed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::preserveAsmComments">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 582,
   FQN="llvm::MCAsmInfo::preserveAsmComments", NM="_ZNK4llvm9MCAsmInfo19preserveAsmCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19preserveAsmCommentsEv")
  //</editor-fold>
  public boolean preserveAsmComments() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Set whether assembly (inline or otherwise) should be parsed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::setPreserveAsmComments">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 585,
   FQN="llvm::MCAsmInfo::setPreserveAsmComments", NM="_ZN4llvm9MCAsmInfo22setPreserveAsmCommentsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo22setPreserveAsmCommentsEb")
  //</editor-fold>
  public /*virtual*/ void setPreserveAsmComments(boolean Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::compressDebugSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 589,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 559,
   FQN="llvm::MCAsmInfo::compressDebugSections", NM="_ZNK4llvm9MCAsmInfo21compressDebugSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo21compressDebugSectionsEv")
  //</editor-fold>
  public DebugCompressionType compressDebugSections() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::setCompressDebugSections">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 593,
   FQN="llvm::MCAsmInfo::setCompressDebugSections", NM="_ZN4llvm9MCAsmInfo24setCompressDebugSectionsENS_20DebugCompressionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo24setCompressDebugSectionsENS_20DebugCompressionTypeE")
  //</editor-fold>
  public void setCompressDebugSections(DebugCompressionType CompressDebugSections) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::shouldUseLogicalShr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 597,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", old_line = 565,
   FQN="llvm::MCAsmInfo::shouldUseLogicalShr", NM="_ZNK4llvm9MCAsmInfo19shouldUseLogicalShrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19shouldUseLogicalShrEv")
  //</editor-fold>
  public boolean shouldUseLogicalShr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::canRelaxRelocations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 599,
   FQN="llvm::MCAsmInfo::canRelaxRelocations", NM="_ZNK4llvm9MCAsmInfo19canRelaxRelocationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm9MCAsmInfo19canRelaxRelocationsEv")
  //</editor-fold>
  public boolean canRelaxRelocations() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmInfo::setRelaxELFRelocations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 600,
   FQN="llvm::MCAsmInfo::setRelaxELFRelocations", NM="_ZN4llvm9MCAsmInfo22setRelaxELFRelocationsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm9MCAsmInfo22setRelaxELFRelocationsEb")
  //</editor-fold>
  public void setRelaxELFRelocations(boolean V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public String toString() {
    return "" + "PointerSize=" + PointerSize // NOI18N
              + ", CalleeSaveStackSlotSize=" + CalleeSaveStackSlotSize // NOI18N
              + ", IsLittleEndian=" + IsLittleEndian // NOI18N
              + ", StackGrowsUp=" + StackGrowsUp // NOI18N
              + ", HasSubsectionsViaSymbols=" + HasSubsectionsViaSymbols // NOI18N
              + ", HasMachoZeroFillDirective=" + HasMachoZeroFillDirective // NOI18N
              + ", HasMachoTBSSDirective=" + HasMachoTBSSDirective // NOI18N
              + ", HasStaticCtorDtorReferenceInStaticMode=" + HasStaticCtorDtorReferenceInStaticMode // NOI18N
              + ", MaxInstLength=" + MaxInstLength // NOI18N
              + ", MinInstAlignment=" + MinInstAlignment // NOI18N
              + ", DollarIsPC=" + DollarIsPC // NOI18N
              + ", SeparatorString=" + SeparatorString // NOI18N
              + ", CommentString=" + CommentString // NOI18N
              + ", LabelSuffix=" + LabelSuffix // NOI18N
              + ", UseAssignmentForEHBegin=" + UseAssignmentForEHBegin // NOI18N
              + ", NeedsLocalForSize=" + NeedsLocalForSize // NOI18N
              + ", PrivateGlobalPrefix=" + PrivateGlobalPrefix // NOI18N
              + ", PrivateLabelPrefix=" + PrivateLabelPrefix // NOI18N
              + ", LinkerPrivateGlobalPrefix=" + LinkerPrivateGlobalPrefix // NOI18N
              + ", InlineAsmStart=" + InlineAsmStart // NOI18N
              + ", InlineAsmEnd=" + InlineAsmEnd // NOI18N
              + ", Code16Directive=" + Code16Directive // NOI18N
              + ", Code32Directive=" + Code32Directive // NOI18N
              + ", Code64Directive=" + Code64Directive // NOI18N
              + ", AssemblerDialect=" + AssemblerDialect // NOI18N
              + ", AllowAtInName=" + AllowAtInName // NOI18N
              + ", SupportsQuotedNames=" + SupportsQuotedNames // NOI18N
              + ", UseDataRegionDirectives=" + UseDataRegionDirectives // NOI18N
              + ", ZeroDirective=" + ZeroDirective // NOI18N
              + ", AsciiDirective=" + AsciiDirective // NOI18N
              + ", AscizDirective=" + AscizDirective // NOI18N
              + ", Data8bitsDirective=" + Data8bitsDirective // NOI18N
              + ", Data16bitsDirective=" + Data16bitsDirective // NOI18N
              + ", Data32bitsDirective=" + Data32bitsDirective // NOI18N
              + ", Data64bitsDirective=" + Data64bitsDirective // NOI18N
              + ", GPRel64Directive=" + GPRel64Directive // NOI18N
              + ", GPRel32Directive=" + GPRel32Directive // NOI18N
              + ", SunStyleELFSectionSwitchSyntax=" + SunStyleELFSectionSwitchSyntax // NOI18N
              + ", UsesELFSectionDirectiveForBSS=" + UsesELFSectionDirectiveForBSS // NOI18N
              + ", NeedsDwarfSectionOffsetDirective=" + NeedsDwarfSectionOffsetDirective // NOI18N
              + ", AlignmentIsInBytes=" + AlignmentIsInBytes // NOI18N
              + ", TextAlignFillValue=" + TextAlignFillValue // NOI18N
              + ", GlobalDirective=" + GlobalDirective // NOI18N
              + ", SetDirectiveSuppressesReloc=" + SetDirectiveSuppressesReloc // NOI18N
              + ", HasAggressiveSymbolFolding=" + HasAggressiveSymbolFolding // NOI18N
              + ", COMMDirectiveAlignmentIsInBytes=" + COMMDirectiveAlignmentIsInBytes // NOI18N
              + ", LCOMMDirectiveAlignmentType=" + LCOMMDirectiveAlignmentType // NOI18N
              + ", HasFunctionAlignment=" + HasFunctionAlignment // NOI18N
              + ", HasDotTypeDotSizeDirective=" + HasDotTypeDotSizeDirective // NOI18N
              + ", HasSingleParameterDotFile=" + HasSingleParameterDotFile // NOI18N
              + ", HasIdentDirective=" + HasIdentDirective // NOI18N
              + ", HasNoDeadStrip=" + HasNoDeadStrip // NOI18N
              + ", HasAltEntry=" + HasAltEntry // NOI18N
              + ", WeakDirective=" + WeakDirective // NOI18N
              + ", WeakRefDirective=" + WeakRefDirective // NOI18N
              + ", HasWeakDefDirective=" + HasWeakDefDirective // NOI18N
              + ", HasWeakDefCanBeHiddenDirective=" + HasWeakDefCanBeHiddenDirective // NOI18N
              + ", HasLinkOnceDirective=" + HasLinkOnceDirective // NOI18N
              + ", HiddenVisibilityAttr=" + HiddenVisibilityAttr // NOI18N
              + ", HiddenDeclarationVisibilityAttr=" + HiddenDeclarationVisibilityAttr // NOI18N
              + ", ProtectedVisibilityAttr=" + ProtectedVisibilityAttr // NOI18N
              + ", SupportsDebugInformation=" + SupportsDebugInformation // NOI18N
              + ", ExceptionsType=" + ExceptionsType // NOI18N
              + ", WinEHEncodingType=" + WinEHEncodingType // NOI18N
              + ", DwarfUsesRelocationsAcrossSections=" + DwarfUsesRelocationsAcrossSections // NOI18N
              + ", DwarfFDESymbolsUseAbsDiff=" + DwarfFDESymbolsUseAbsDiff // NOI18N
              + ", DwarfRegNumForCFI=" + DwarfRegNumForCFI // NOI18N
              + ", UseParensForSymbolVariant=" + UseParensForSymbolVariant // NOI18N
              + ", InitialFrameState=" + InitialFrameState // NOI18N
              + ", UseIntegratedAssembler=" + UseIntegratedAssembler // NOI18N
              + ", PreserveAsmComments=" + PreserveAsmComments // NOI18N
              + ", CompressDebugSections=" + CompressDebugSections // NOI18N
              + ", UseLogicalShr=" + UseLogicalShr // NOI18N
              + ", RelaxELFRelocations=" + RelaxELFRelocations; // NOI18N
  }
}
