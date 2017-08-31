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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.adt.java.ADTFunctionPointers.UInt2StringRef;
import org.llvm.mc.impl.MCSectionMachOStatics;
import static org.llvm.mc.impl.MCSectionMachOStatics.SectionAttrDescriptors;
import static org.llvm.mc.impl.MCSectionMachOStatics.SectionTypeDescriptors;


/// This represents a section on a Mach-O system (used by Mac OS X).  On a Mac
/// system, these are also described in /usr/include/mach-o/loader.h.
//<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 25,
 FQN="llvm::MCSectionMachO", NM="_ZN4llvm14MCSectionMachOE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm14MCSectionMachOE")
//</editor-fold>
public final class MCSectionMachO extends /*public*/ MCSection implements Destructors.ClassWithDestructor {
  private /*char*/byte SegmentName[/*16*/] = new$char(16); // Not necessarily null terminated!
  private /*char*/byte SectionName[/*16*/] = new$char(16); // Not necessarily null terminated!
  
  /// This is the SECTION_TYPE and SECTION_ATTRIBUTES field of a section, drawn
  /// from the enums below.
  private /*uint*/int TypeAndAttributes;
  
  /// The 'reserved2' field of a section, used to represent the size of stubs,
  /// for example.
  private /*uint*/int Reserved2;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::MCSectionMachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 72,
   FQN="llvm::MCSectionMachO::MCSectionMachO", NM="_ZN4llvm14MCSectionMachOC1ENS_9StringRefES1_jjNS_11SectionKindEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZN4llvm14MCSectionMachOC1ENS_9StringRefES1_jjNS_11SectionKindEPNS_8MCSymbolE")
  //</editor-fold>
  public MCSectionMachO(StringRef Segment, StringRef Section, 
      /*uint*/int TAA, /*uint*/int reserved2, SectionKind K, 
      MCSymbol /*P*/ Begin) {
    // : MCSection(SV_MachO, K, Begin), TypeAndAttributes(TAA), Reserved2(reserved2) 
    //START JInit
    super(SectionVariant.SV_MachO, new SectionKind(K), Begin);
    this.TypeAndAttributes = TAA;
    this.Reserved2 = reserved2;
    //END JInit
    assert ($lesseq_uint(Segment.size(), 16) && $lesseq_uint(Section.size(), 16)) : "Segment or section string too long";
    for (/*uint*/int i = 0; i != 16; ++i) {
      if ($less_uint(i, Segment.size())) {
        SegmentName[i] = Segment.$at(i);
      } else {
        SegmentName[i] = 0;
      }
      if ($less_uint(i, Section.size())) {
        SectionName[i] = Section.$at(i);
      } else {
        SectionName[i] = 0;
      }
    }
  }


  /*friend  class MCContext*/
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::getSegmentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 42,
   FQN="llvm::MCSectionMachO::getSegmentName", NM="_ZNK4llvm14MCSectionMachO14getSegmentNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO14getSegmentNameEv")
  //</editor-fold>
  public StringRef getSegmentName() /*const*/ {
    // SegmentName is not necessarily null terminated!
    if ((SegmentName[15] != 0)) {
      return new StringRef(SegmentName, 16);
    }
    return new StringRef(SegmentName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::getSectionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 48,
   FQN="llvm::MCSectionMachO::getSectionName", NM="_ZNK4llvm14MCSectionMachO14getSectionNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO14getSectionNameEv")
  //</editor-fold>
  public StringRef getSectionName() /*const*/ {
    // SectionName is not necessarily null terminated!
    if ((SectionName[15] != 0)) {
      return new StringRef(SectionName, 16);
    }
    return new StringRef(SectionName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::getTypeAndAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 55,
   FQN="llvm::MCSectionMachO::getTypeAndAttributes", NM="_ZNK4llvm14MCSectionMachO20getTypeAndAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO20getTypeAndAttributesEv")
  //</editor-fold>
  public /*uint*/int getTypeAndAttributes() /*const*/ {
    return TypeAndAttributes;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::getStubSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 56,
   FQN="llvm::MCSectionMachO::getStubSize", NM="_ZNK4llvm14MCSectionMachO11getStubSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO11getStubSizeEv")
  //</editor-fold>
  public /*uint*/int getStubSize() /*const*/ {
    return Reserved2;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 58,
   FQN="llvm::MCSectionMachO::getType", NM="_ZNK4llvm14MCSectionMachO7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO7getTypeEv")
  //</editor-fold>
  public /*MachO::SectionType*//*uint32_t*/int getType() /*const*/ {
    return ((/*static_cast*//*MachO::SectionType*//*uint32_t*/int)(TypeAndAttributes
       & MachO.SECTION_TYPE));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::hasAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 62,
   FQN="llvm::MCSectionMachO::hasAttribute", NM="_ZNK4llvm14MCSectionMachO12hasAttributeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm14MCSectionMachO12hasAttributeEj")
  //</editor-fold>
  public boolean hasAttribute(/*uint*/int Value) /*const*/ {
    return (TypeAndAttributes & Value) != 0;
  }

  
  /// Parse the section specifier indicated by "Spec". This is a string that can
  /// appear after a .section directive in a mach-o flavored .s file.  If
  /// successful, this fills in the specified Out parameters and returns an
  /// empty string.  When an invalid section specifier is present, this returns
  /// a string indicating the problem. If no TAA was parsed, TAA is not altered,
  /// and TAAWasSet becomes false.
  
  /// Parse the section specifier indicated by "Spec". This is a string that can
  /// appear after a .section directive in a mach-o flavored .s file.  If
  /// successful, this fills in the specified Out parameters and returns an
  /// empty string.  When an invalid section specifier is present, this returns
  /// a string indicating the problem. If no TAA was parsed, TAA is not altered,
  /// and TAAWasSet becomes false.
  
  /// Parse the section specifier indicated by "Spec". This is a string that can
  /// appear after a .section directive in a mach-o flavored .s file.  If
  /// successful, this fills in the specified Out parameters and returns an
  /// empty string.  When an invalid section specifier is present, this returns
  /// a string indicating the problem. If no TAA was parsed, TAA is not altered,
  /// and TAAWasSet becomes false.

  /// ParseSectionSpecifier - Parse the section specifier indicated by "Spec".
  /// This is a string that can appear after a .section directive in a mach-o
  /// flavored .s file.  If successful, this fills in the specified Out
  /// parameters and returns an empty string.  When an invalid section
  /// specifier is present, this returns a string indicating the problem.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::ParseSectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 171,
   FQN="llvm::MCSectionMachO::ParseSectionSpecifier", NM="_ZN4llvm14MCSectionMachO21ParseSectionSpecifierENS_9StringRefERS1_S2_RjRbS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZN4llvm14MCSectionMachO21ParseSectionSpecifierENS_9StringRefERS1_S2_RjRbS3_")
  //</editor-fold>
  public static std.string ParseSectionSpecifier(StringRef Spec,  // In.
                       final StringRef /*&*/ Segment,  // Out.
                       final StringRef /*&*/ Section,  // Out.
                       final uint$ref/*uint &*/ TAA,  // Out.
                       final bool$ref/*bool &*/ TAAParsed,  // Out.
                       final uint$ref/*uint &*/ StubSize) {
    // Out.
    TAAParsed.$set(false);
    
    SmallVector<StringRef> SplitSpec/*J*/= new SmallVector<StringRef>(5, new StringRef());
    Spec.split(SplitSpec, $$COMMA);
    // Remove leading and trailing whitespace.
    UInt2StringRef GetEmptyOrTrim = /*[&SplitSpec]*/ (/*size_t*/int Idx) -> {
          return $greater_uint(SplitSpec.size(), Idx) ? SplitSpec.$at(Idx).trim() : new StringRef();
        };
    Segment.$assignMove(GetEmptyOrTrim.$call(0));
    Section.$assignMove(GetEmptyOrTrim.$call(1));
    StringRef SectionType = GetEmptyOrTrim.$call(2);
    StringRef Attrs = GetEmptyOrTrim.$call(3);
    StringRef StubSizeStr = GetEmptyOrTrim.$call(4);
    
    // Verify that the segment is present and not too long.
    if (Segment.empty() || $greater_uint(Segment.size(), 16)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier requires a segment whose length is between 1 and 16 characters");
    }
    
    // Verify that the section is present and not too long.
    if (Section.empty()) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier requires a segment and section separated by a comma");
    }
    if ($greater_uint(Section.size(), 16)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier requires a section whose length is between 1 and 16 characters");
    }
    
    // If there is no comma after the section, we're done.
    TAA.$set(0);
    StubSize.$set(0);
    if (SectionType.empty()) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    
    // Figure out which section type it is.
    /*const*/ type$ptr<MCSectionMachOStatics.Unnamed_struct1> /*P*/ TypeDescriptor = std.find_if(std.begin(SectionTypeDescriptors), std.end(SectionTypeDescriptors), 
        /*[&, &SectionType]*/ (MCSectionMachOStatics.Unnamed_struct1 /*&*/ Descriptor) -> {
              return Native.$bool(Descriptor.AssemblerName)
                 && $eq_StringRef(/*NO_COPY*/SectionType, /*STRINGREF_STR*/Descriptor.AssemblerName);
            });
    
    // If we didn't find the section type, reject it.
    if (TypeDescriptor == std.end(SectionTypeDescriptors)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier uses an unknown section type");
    }
    
    // Remember the TypeID.
    TAA.$set(TypeDescriptor.$sub(std.begin(SectionTypeDescriptors)));
    TAAParsed.$set(true);
    
    // If we have no comma after the section type, there are no attributes.
    if (Attrs.empty()) {
      // S_SYMBOL_STUBS always require a symbol stub size specifier.
      if (TAA.$deref() == MachO.SectionType.S_SYMBOL_STUBS) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier of type 'symbol_stubs' requires a size specifier");
      }
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    
    // The attribute list is a '+' separated list of attributes.
    SmallVector<StringRef> SectionAttrs/*J*/= new SmallVector<StringRef>(1, new StringRef());
    Attrs.split(SectionAttrs, $$PLUS, /*MaxSplit=*/ -1, /*KEEP_BOOL*//*KeepEmpty=*/ false);
    
    for (final StringRef /*&*/ SectionAttr : SectionAttrs) {
      /*const*/ type$ptr<MCSectionMachOStatics.Unnamed_struct2> /*P*/ AttrDescriptorI = std.find_if(std.begin(SectionAttrDescriptors), std.end(SectionAttrDescriptors), 
          /*[&, &SectionAttr]*/ (MCSectionMachOStatics.Unnamed_struct2 /*&*/ Descriptor) -> {
                return Native.$bool(Descriptor.AssemblerName)
                   && $eq_StringRef(SectionAttr.trim(), /*STRINGREF_STR*/Descriptor.AssemblerName);
              });
      if (AttrDescriptorI == std.end(SectionAttrDescriptors)) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier has invalid attribute");
      }
      
      TAA.$set$orassign(AttrDescriptorI.$star().AttrFlag);
    }
    
    // Okay, we've parsed the section attributes, see if we have a stub size spec.
    if (StubSizeStr.empty()) {
      // S_SYMBOL_STUBS always require a symbol stub size specifier.
      if (TAA.$deref() == MachO.SectionType.S_SYMBOL_STUBS) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier of type 'symbol_stubs' requires a size specifier");
      }
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    }
    
    // If we have a stub size spec, we must have a sectiontype of S_SYMBOL_STUBS.
    if ((TAA.$deref() & MachO.SECTION_TYPE) != MachO.SectionType.S_SYMBOL_STUBS) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier cannot have a stub size specified because it does not have type 'symbol_stubs'");
    }
    
    // Convert the stub size from a string to an integer.
    if (StubSizeStr.getAsInteger$NotSigned(0, StubSize)) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mach-o section specifier has a malformed stub size");
    }
    
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }
 // Out.

  // Out.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::PrintSwitchToSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 92,
   FQN="llvm::MCSectionMachO::PrintSwitchToSection", NM="_ZNK4llvm14MCSectionMachO20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZNK4llvm14MCSectionMachO20PrintSwitchToSectionERKNS_9MCAsmInfoERNS_11raw_ostreamEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void PrintSwitchToSection(final /*const*/ MCAsmInfo /*&*/ MAI, 
                      final raw_ostream /*&*/ OS, 
                      /*const*/ MCExpr /*P*/ Subsection) /*const*//* override*/ {
    OS.$out(/*KEEP_STR*/"\t.section\t").$out(getSegmentName()).$out_char($$COMMA).$out(getSectionName());
    
    // Get the section type and attributes.
    /*uint*/int TAA = getTypeAndAttributes();
    if (TAA == 0) {
      OS.$out_char($$LF);
      return;
    }
    
    /*MachO::SectionType*//*uint32_t*/int SectionType = getType();
    assert ($lesseq_uint(SectionType, MachO.SectionType.LAST_KNOWN_SECTION_TYPE)) : "Invalid SectionType specified!";
    if (Native.$bool(SectionTypeDescriptors[SectionType].AssemblerName)) {
      OS.$out_char($$COMMA);
      OS.$out(SectionTypeDescriptors[SectionType].AssemblerName);
    } else {
      // If we have no name for the attribute, stop here.
      OS.$out_char($$LF);
      return;
    }
    
    // If we don't have any attributes, we're done.
    /*uint*/int SectionAttrs = TAA & MachO.SECTION_ATTRIBUTES;
    if (SectionAttrs == 0) {
      // If we have a S_SYMBOL_STUBS size specified, print it along with 'none' as
      // the attribute specifier.
      if (Reserved2 != 0) {
        OS.$out(/*KEEP_STR*/",none,").$out_uint(Reserved2);
      }
      OS.$out_char($$LF);
      return;
    }
    
    // Check each attribute to see if we have it.
    /*char*/byte Separator = $$COMMA;
    for (/*uint*/int i = 0;
         SectionAttrs != 0 && (SectionAttrDescriptors[i].AttrFlag != 0);
         ++i) {
      // Check to see if we have this attribute.
      if ((SectionAttrDescriptors[i].AttrFlag & SectionAttrs) == 0) {
        continue;
      }
      
      // Yep, clear it and print it.
      SectionAttrs &= ~SectionAttrDescriptors[i].AttrFlag;
      
      OS.$out_char(Separator);
      if (Native.$bool(SectionAttrDescriptors[i].AssemblerName)) {
        OS.$out(SectionAttrDescriptors[i].AssemblerName);
      } else {
        OS.$out(/*KEEP_STR*/$LT_LT).$out(SectionAttrDescriptors[i].EnumName).$out(/*KEEP_STR*/$GT_GT);
      }
      Separator = $$PLUS;
    }
    assert (SectionAttrs == 0) : "Unknown section attributes!";
    
    // If we have a S_SYMBOL_STUBS size specified, print it.
    if (Reserved2 != 0) {
      OS.$out_char($$COMMA).$out_uint(Reserved2);
    }
    OS.$out_char($$LF);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::UseCodeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 156,
   FQN="llvm::MCSectionMachO::UseCodeAlign", NM="_ZNK4llvm14MCSectionMachO12UseCodeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZNK4llvm14MCSectionMachO12UseCodeAlignEv")
  //</editor-fold>
  @Override public boolean UseCodeAlign() /*const*//* override*/ {
    return hasAttribute(MachO.S_ATTR_PURE_INSTRUCTIONS);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::isVirtualSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp", line = 160,
   FQN="llvm::MCSectionMachO::isVirtualSection", NM="_ZNK4llvm14MCSectionMachO16isVirtualSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSectionMachO.cpp -nm=_ZNK4llvm14MCSectionMachO16isVirtualSectionEv")
  //</editor-fold>
  @Override public boolean isVirtualSection() /*const*//* override*/ {
    return (getType() == MachO.SectionType.S_ZEROFILL
       || getType() == MachO.SectionType.S_GB_ZEROFILL
       || getType() == MachO.SectionType.S_THREAD_LOCAL_ZEROFILL);
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 84,
   FQN="llvm::MCSectionMachO::classof", NM="_ZN4llvm14MCSectionMachO7classofEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm14MCSectionMachO7classofEPKNS_9MCSectionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSection /*P*/ S) {
    return S.getVariant() == SectionVariant.SV_MachO;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSectionMachO::~MCSectionMachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSectionMachO.h", line = 25,
   FQN="llvm::MCSectionMachO::~MCSectionMachO", NM="_ZN4llvm14MCSectionMachOD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm14MCSectionMachOD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "SegmentName=" + SegmentName // NOI18N
              + ", SectionName=" + SectionName // NOI18N
              + ", TypeAndAttributes=" + TypeAndAttributes // NOI18N
              + ", Reserved2=" + Reserved2 // NOI18N
              + super.toString(); // NOI18N
  }
}
