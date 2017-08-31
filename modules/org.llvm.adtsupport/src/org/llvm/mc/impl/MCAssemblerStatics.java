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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.*;
import static org.llvm.mc.stats.impl.StatsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type MCAssemblerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCAssemblerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZL13writeFragmentRKN4llvm11MCAssemblerERKNS_11MCAsmLayoutERKNS_10MCFragmentE; -static-type=MCAssemblerStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCAssemblerStatics {


/// \brief Write the fragment \p F to the output file.
//<editor-fold defaultstate="collapsed" desc="writeFragment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", line = 421,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp", old_line = 416,
 FQN="writeFragment", NM="_ZL13writeFragmentRKN4llvm11MCAssemblerERKNS_11MCAsmLayoutERKNS_10MCFragmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZL13writeFragmentRKN4llvm11MCAssemblerERKNS_11MCAsmLayoutERKNS_10MCFragmentE")
//</editor-fold>
public static void writeFragment(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCAsmLayout /*&*/ Layout, 
             final /*const*/ MCFragment /*&*/ F) {
  MCObjectWriter /*P*/ OW = $AddrOf(Asm.getWriter());
  
  // FIXME: Embed in fragments instead?
  long/*uint64_t*/ FragmentSize = Asm.computeFragmentSize(Layout, F);
  
  Asm.writeFragmentPadding(F, FragmentSize, OW);
  
  // This variable (and its dummy usage) is to participate in the assert at
  // the end of the function.
  long/*uint64_t*/ Start = OW.getStream().tell();
  ///*J:(void)*/Start;
  
  EmittedFragments.$preInc();
  switch (F.getKind()) {
   case FT_Align:
    {
      EmittedAlignFragments.$preInc();
      final /*const*/ MCAlignFragment /*&*/ AF = cast_MCAlignFragment(F);
      assert ((AF.getValueSize() != 0)) : "Invalid virtual align in concrete fragment!";
      
      long/*uint64_t*/ Count = $div_ulong_uint(FragmentSize, AF.getValueSize());
      
      // FIXME: This error shouldn't actually occur (the front end should emit
      // multiple .align directives to enforce the semantics it wants), but is
      // severe enough that we want to report it. How to handle this?
      if (Count * $uint2ullong(AF.getValueSize()) != FragmentSize) {
        report_fatal_error($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"undefined .align directive, value size '"), 
                            new Twine(JD$UInt.INSTANCE, AF.getValueSize())), 
                        new Twine(/*KEEP_STR*/"' is not a divisor of padding size '")), 
                    new Twine(JD$ConstULLongRef.INSTANCE, FragmentSize)), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      }
      
      // See if we are aligning with nops, and if so do that first to try to fill
      // the Count bytes.  Then if that did not fill any bytes or there are any
      // bytes left to fill use the Value and ValueSize to fill the rest.
      // If we are aligning with nops, ask that target to emit the right data.
      if (AF.hasEmitNops()) {
        if (!Asm.getBackend().writeNopData(Count, OW)) {
          report_fatal_error($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"unable to write nop sequence of "), 
                      new Twine(JD$ConstULLongRef.INSTANCE, Count)), new Twine(/*KEEP_STR*/" bytes")));
        }
        break;
      }
      
      // Otherwise, write out in multiples of the value size.
      for (long/*uint64_t*/ i = $int2ulong(0); i != Count; ++i) {
        switch (AF.getValueSize()) {
         default:
          throw new llvm_unreachable("Invalid size!");
         case 1:
          OW.write8(((byte/*uint8_t*/)($long2uchar(AF.getValue()))));
          break;
         case 2:
          OW.write16(((/*uint16_t*/char)($long2ushort(AF.getValue()))));
          break;
         case 4:
          OW.write32(((/*uint32_t*/int)($long2uint(AF.getValue()))));
          break;
         case 8:
          OW.write64(((long/*uint64_t*/)(AF.getValue())));
          break;
        }
      }
      break;
    }
   case FT_Data:
    EmittedDataFragments.$preInc();
    OW.writeBytes(cast_MCDataFragment(F).getContents$Const());
    break;
   case FT_Relaxable:
    EmittedRelaxableFragments.$preInc();
    OW.writeBytes(cast_MCRelaxableFragment(F).getContents$Const());
    break;
   case FT_CompactEncodedInst:
    EmittedCompactEncodedInstFragments.$preInc();
    OW.writeBytes(cast_MCCompactEncodedInstFragment(F).getContents$Const());
    break;
   case FT_Fill:
    {
      EmittedFillFragments.$preInc();
      final /*const*/ MCFillFragment /*&*/ FF = cast_MCFillFragment(F);
      uchar$ptr V = create_uchar$ptr(new byte[]{FF.getValue()});
      /*const*//*uint*/int MaxChunkSize = 16;
      /*char*/byte Data[/*16*/] = new$char(16);
      memcpy(Data, $AddrOf(V), 1);
      for (/*uint*/int I = 1; $less_uint(I, MaxChunkSize); ++I)  {
        Data[I] = Data[0];
      }
      
      long/*uint64_t*/ Size = FF.getSize();
      for (/*uint*/int ChunkSize = MaxChunkSize; (ChunkSize != 0); ChunkSize = $div_uint(ChunkSize, 2)) {
        StringRef Ref/*J*/= new StringRef(Data, ChunkSize);
        for (long/*uint64_t*/ I = $int2ulong(0), E = $div_ulong_uint(Size, ChunkSize); I != E; ++I)  {
          OW.writeBytes(new StringRef(Ref));
        }
        Size = $rem_ulong_uint(Size, ChunkSize);
      }
      break;
    }
   case FT_LEB:
    {
      final /*const*/ MCLEBFragment /*&*/ LF = cast_MCLEBFragment(F);
      OW.writeBytes(LF.getContents$Const());
      break;
    }
   case FT_SafeSEH:
    {
      final /*const*/ MCSafeSEHFragment /*&*/ SF = cast_MCSafeSEHFragment(F);
      OW.write32(SF.getSymbol$Const().getIndex());
      break;
    }
   case FT_Org:
    {
      EmittedOrgFragments.$preInc();
      final /*const*/ MCOrgFragment /*&*/ OF = cast_MCOrgFragment(F);
      
      for (long/*uint64_t*/ i = $int2ulong(0), e = FragmentSize; i != e; ++i)  {
        OW.write8(((byte/*uint8_t*/)(OF.getValue())));
      }
      
      break;
    }
   case FT_Dwarf:
    {
      final /*const*/ MCDwarfLineAddrFragment /*&*/ OF = cast_MCDwarfLineAddrFragment(F);
      OW.writeBytes(OF.getContents$Const());
      break;
    }
   case FT_DwarfFrame:
    {
      final /*const*/ MCDwarfCallFrameFragment /*&*/ CF = cast_MCDwarfCallFrameFragment(F);
      OW.writeBytes(CF.getContents$Const());
      break;
    }
   case FT_CVInlineLines:
    {
      final /*const*/ MCCVInlineLineTableFragment /*&*/ OF = cast_MCCVInlineLineTableFragment(F);
      OW.writeBytes(OF.getContents$Const());
      break;
    }
   case FT_CVDefRange:
    {
      final /*const*/ MCCVDefRangeFragment /*&*/ DRF = cast_MCCVDefRangeFragment(F);
      OW.writeBytes(DRF.getContents$Const());
      break;
    }
   case FT_Dummy:
    throw new llvm_unreachable("Should not have been added");
  }
  assert (OW.getStream().tell() - Start == FragmentSize) : "The stream should advance by fragment size";
}

} // END OF class MCAssemblerStatics
