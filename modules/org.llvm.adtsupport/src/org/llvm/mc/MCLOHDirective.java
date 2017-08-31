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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.AdtsupportLlvmGlobals.encodeULEB128;


/// Store Linker Optimization Hint information (LOH).
//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 100,
 FQN="llvm::MCLOHDirective", NM="_ZN4llvm14MCLOHDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvm14MCLOHDirectiveE")
//</editor-fold>
public class MCLOHDirective implements Destructors.ClassWithDestructor {
  private /*MCLOHType*//*uint*/int Kind;
  
  /// Arguments of this directive. Order matters.
  private SmallVector<MCSymbol /*P*/ > Args;
  
  /// Emit this directive in \p OutStream using the information available
  /// in the given \p ObjWriter and \p Layout to get the address of the
  /// arguments within the object file.
  
  // Each LOH is composed by, in this order (each field is encoded using ULEB128):
  // - Its kind.
  // - Its number of arguments (let say N).
  // - Its arg1.
  // - ...
  // - Its argN.
  // <arg1> to <argN> are absolute addresses in the object file, i.e.,
  // relative addresses from the beginning of the object file.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::emit_impl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 26,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", old_line = 25,
   FQN="llvm::MCLOHDirective::emit_impl", NM="_ZNK4llvm14MCLOHDirective9emit_implERNS_11raw_ostreamERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZNK4llvm14MCLOHDirective9emit_implERNS_11raw_ostreamERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE")
  //</editor-fold>
  private void emit_impl(final raw_ostream /*&*/ OutStream, 
           final /*const*/ MachObjectWriter /*&*/ ObjWriter, 
           final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    encodeULEB128($uint2ulong(Kind), OutStream);
    encodeULEB128($uint2ulong(Args.size()), OutStream);
    for (/*const*/ MCSymbol /*P*/ Arg : Args)  {
      encodeULEB128(ObjWriter.getSymbolAddress($Deref(Arg), Layout), OutStream);
    }
  }

/*public:*/
  // JAVA: typedef SmallVectorImpl<MCSymbol *> LOHArgs
//  public final class LOHArgs extends SmallVectorImpl<MCSymbol /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::MCLOHDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 115,
   FQN="llvm::MCLOHDirective::MCLOHDirective", NM="_ZN4llvm14MCLOHDirectiveC1ENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvm14MCLOHDirectiveC1ENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE")
  //</editor-fold>
  public MCLOHDirective(/*MCLOHType*//*uint*/int Kind, final /*const*/ SmallVectorImpl<MCSymbol /*P*/ > /*&*/ Args) {
    // : Kind(Kind), Args(Args.begin(), Args.end()) 
    //START JInit
    this.Kind = Kind;
    this.Args = new SmallVector<MCSymbol /*P*/ >(JD$T.INSTANCE, 3, Args.begin$Const(), Args.end$Const(), (MCSymbol /*P*/ )null);
    //END JInit
    assert (AdtsupportLlvmGlobals.isValidMCLOHType(Kind)) : "Invalid LOH directive type!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 120,
   FQN="llvm::MCLOHDirective::getKind", NM="_ZNK4llvm14MCLOHDirective7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZNK4llvm14MCLOHDirective7getKindEv")
  //</editor-fold>
  public /*MCLOHType*//*uint*/int getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 122,
   FQN="llvm::MCLOHDirective::getArgs", NM="_ZNK4llvm14MCLOHDirective7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZNK4llvm14MCLOHDirective7getArgsEv")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCSymbol /*P*/ > /*&*/ getArgs() /*const*/ {
    return Args;
  }

  
  /// Emit this directive as:
  /// <kind, numArgs, addr1, ..., addrN>
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 35,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 126,
   FQN="llvm::MCLOHDirective::emit", NM="_ZNK4llvm14MCLOHDirective4emitERNS_16MachObjectWriterERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZNK4llvm14MCLOHDirective4emitERNS_16MachObjectWriterERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public void emit(final MachObjectWriter /*&*/ ObjWriter, 
      final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    final raw_ostream /*&*/ OutStream = ObjWriter.getStream();
    emit_impl(OutStream, ObjWriter, Layout);
  }

  
  /// Get the size in bytes of this directive if emitted in \p ObjWriter with
  /// the given \p Layout.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getEmitSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", old_line = 133,
   FQN="llvm::MCLOHDirective::getEmitSize", NM="_ZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public long/*uint64_t*/ getEmitSize(final /*const*/ MachObjectWriter /*&*/ ObjWriter, 
             final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    getEmitSize$$.raw_counting_ostream OutStream = null;
    try {
      ;
      
      OutStream/*J*/= new getEmitSize$$.raw_counting_ostream();
      emit_impl(OutStream, ObjWriter, Layout);
      return OutStream.tell();
    } finally {
      if (OutStream != null) { OutStream.$destroy(); }
    }
  }
  private static final class getEmitSize$$ {
    static //<editor-fold defaultstate="collapsed" desc="raw_counting_ostream">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 43,
     FQN="raw_counting_ostream", NM="_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEE20raw_counting_ostream",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEE20raw_counting_ostream")
    //</editor-fold>
     class raw_counting_ostream extends /*public*/ raw_ostream implements Destructors.ClassWithDestructor {
      private long/*uint64_t*/ Count;
      
      //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::write_impl">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 46,
       FQN="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::write_impl", NM="_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostream10write_implEPKcj",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostream10write_implEPKcj")
      //</editor-fold>
      @Override protected/*private*/ void write_impl(/*const*/char$ptr/*char P*/ $Prm0,  int PtrIdx, /*size_t*/int size)/* override*/ {
        Count += $uint2ullong(size);
      }
      
      //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::current_pos">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 48,
       FQN="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::current_pos", NM="_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEENK20raw_counting_ostream11current_posEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEENK20raw_counting_ostream11current_posEv")
      //</editor-fold>
      @Override protected/*private*/ long/*uint64_t*/ current_pos() /*const*//* override*/ {
        return Count;
      }
    
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::raw_counting_ostream">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 51,
       FQN="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::raw_counting_ostream", NM="_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostreamC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostreamC1Ev")
      //</editor-fold>
      public raw_counting_ostream() {
        // : raw_ostream(), Count(0) 
        //START JInit
        super();
        this.Count = $int2ulong(0);
        //END JInit
      }
    
      //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::~raw_counting_ostream">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp", line = 52,
       FQN="llvm::MCLOHDirective::getEmitSize(const MachObjectWriter & , const MCAsmLayout & )::raw_counting_ostream::~raw_counting_ostream", NM="_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostreamD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZZNK4llvm14MCLOHDirective11getEmitSizeERKNS_16MachObjectWriterERKNS_11MCAsmLayoutEEN20raw_counting_ostreamD0Ev")
      //</editor-fold>
      @Override public void $destroy()/* override*/ {
        flush();
        super.$destroy();
      }
    
      
      @Override public String toString() {
        return "" + "Count=" + Count // NOI18N
                  + super.toString(); // NOI18N
      }

    };
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::MCLOHDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 100,
   FQN="llvm::MCLOHDirective::MCLOHDirective", NM="_ZN4llvm14MCLOHDirectiveC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvm14MCLOHDirectiveC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCLOHDirective(JD$Move _dparam, final MCLOHDirective /*&&*/$Prm0) {
    // : Kind(static_cast<MCLOHDirective &&>().Kind), Args(static_cast<MCLOHDirective &&>().Args) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Args = new SmallVector<MCSymbol /*P*/ >(JD$Move.INSTANCE, $Prm0.Args);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCLOHDirective::~MCLOHDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 100,
   FQN="llvm::MCLOHDirective::~MCLOHDirective", NM="_ZN4llvm14MCLOHDirectiveD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvm14MCLOHDirectiveD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Args.$destroy();
    //END JDestroy
  }

  public MCLOHDirective() {
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Args=" + Args; // NOI18N
  }
}
