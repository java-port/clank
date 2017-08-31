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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.llvm.mc.MCContextGlobals.$new_uint_MCContext_uint;


/// \brief  Represent a reference to a symbol from inside an expression.
///
/// A symbol reference in an expression may be a use of a label, a use of an
/// assembler variable (defined constant), or constitute an implicit definition
/// of the symbol as external.
//<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 161,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 160,
 FQN="llvm::MCSymbolRefExpr", NM="_ZN4llvm15MCSymbolRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExprE")
//</editor-fold>
public class MCSymbolRefExpr extends /*public*/ MCExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::VariantKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 162,
   FQN="llvm::MCSymbolRefExpr::VariantKind", NM="_ZN4llvm15MCSymbolRefExpr11VariantKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr11VariantKindE")
  //</editor-fold>
  public enum VariantKind/* : uint16_t*/ implements Native.NativeUShortEnum {
    VK_None(0),
    VK_Invalid(VK_None.getValue() + 1),
    
    VK_GOT(VK_Invalid.getValue() + 1),
    VK_GOTOFF(VK_GOT.getValue() + 1),
    VK_GOTREL(VK_GOTOFF.getValue() + 1),
    VK_GOTPCREL(VK_GOTREL.getValue() + 1),
    VK_GOTTPOFF(VK_GOTPCREL.getValue() + 1),
    VK_INDNTPOFF(VK_GOTTPOFF.getValue() + 1),
    VK_NTPOFF(VK_INDNTPOFF.getValue() + 1),
    VK_GOTNTPOFF(VK_NTPOFF.getValue() + 1),
    VK_PLT(VK_GOTNTPOFF.getValue() + 1),
    VK_TLSGD(VK_PLT.getValue() + 1),
    VK_TLSLD(VK_TLSGD.getValue() + 1),
    VK_TLSLDM(VK_TLSLD.getValue() + 1),
    VK_TPOFF(VK_TLSLDM.getValue() + 1),
    VK_DTPOFF(VK_TPOFF.getValue() + 1),
    VK_TLSCALL(VK_DTPOFF.getValue() + 1), // symbol(tlscall)
    VK_TLSDESC(VK_TLSCALL.getValue() + 1), // symbol(tlsdesc)
    VK_TLVP(VK_TLSDESC.getValue() + 1), // Mach-O thread local variable relocations
    VK_TLVPPAGE(VK_TLVP.getValue() + 1),
    VK_TLVPPAGEOFF(VK_TLVPPAGE.getValue() + 1),
    VK_PAGE(VK_TLVPPAGEOFF.getValue() + 1),
    VK_PAGEOFF(VK_PAGE.getValue() + 1),
    VK_GOTPAGE(VK_PAGEOFF.getValue() + 1),
    VK_GOTPAGEOFF(VK_GOTPAGE.getValue() + 1),
    VK_SECREL(VK_GOTPAGEOFF.getValue() + 1),
    VK_SIZE(VK_SECREL.getValue() + 1), // symbol@SIZE
    VK_WEAKREF(VK_SIZE.getValue() + 1), // The link between the symbols in .weakref foo, bar
    
    VK_ARM_NONE(VK_WEAKREF.getValue() + 1),
    VK_ARM_GOT_PREL(VK_ARM_NONE.getValue() + 1),
    VK_ARM_TARGET1(VK_ARM_GOT_PREL.getValue() + 1),
    VK_ARM_TARGET2(VK_ARM_TARGET1.getValue() + 1),
    VK_ARM_PREL31(VK_ARM_TARGET2.getValue() + 1),
    VK_ARM_SBREL(VK_ARM_PREL31.getValue() + 1), // symbol(sbrel)
    VK_ARM_TLSLDO(VK_ARM_SBREL.getValue() + 1), // symbol(tlsldo)
    VK_ARM_TLSDESCSEQ(VK_ARM_TLSLDO.getValue() + 1),
    
    VK_PPC_LO(VK_ARM_TLSDESCSEQ.getValue() + 1), // symbol@l
    VK_PPC_HI(VK_PPC_LO.getValue() + 1), // symbol@h
    VK_PPC_HA(VK_PPC_HI.getValue() + 1), // symbol@ha
    VK_PPC_HIGHER(VK_PPC_HA.getValue() + 1), // symbol@higher
    VK_PPC_HIGHERA(VK_PPC_HIGHER.getValue() + 1), // symbol@highera
    VK_PPC_HIGHEST(VK_PPC_HIGHERA.getValue() + 1), // symbol@highest
    VK_PPC_HIGHESTA(VK_PPC_HIGHEST.getValue() + 1), // symbol@highesta
    VK_PPC_GOT_LO(VK_PPC_HIGHESTA.getValue() + 1), // symbol@got@l
    VK_PPC_GOT_HI(VK_PPC_GOT_LO.getValue() + 1), // symbol@got@h
    VK_PPC_GOT_HA(VK_PPC_GOT_HI.getValue() + 1), // symbol@got@ha
    VK_PPC_TOCBASE(VK_PPC_GOT_HA.getValue() + 1), // symbol@tocbase
    VK_PPC_TOC(VK_PPC_TOCBASE.getValue() + 1), // symbol@toc
    VK_PPC_TOC_LO(VK_PPC_TOC.getValue() + 1), // symbol@toc@l
    VK_PPC_TOC_HI(VK_PPC_TOC_LO.getValue() + 1), // symbol@toc@h
    VK_PPC_TOC_HA(VK_PPC_TOC_HI.getValue() + 1), // symbol@toc@ha
    VK_PPC_DTPMOD(VK_PPC_TOC_HA.getValue() + 1), // symbol@dtpmod
    VK_PPC_TPREL_LO(VK_PPC_DTPMOD.getValue() + 1), // symbol@tprel@l
    VK_PPC_TPREL_HI(VK_PPC_TPREL_LO.getValue() + 1), // symbol@tprel@h
    VK_PPC_TPREL_HA(VK_PPC_TPREL_HI.getValue() + 1), // symbol@tprel@ha
    VK_PPC_TPREL_HIGHER(VK_PPC_TPREL_HA.getValue() + 1), // symbol@tprel@higher
    VK_PPC_TPREL_HIGHERA(VK_PPC_TPREL_HIGHER.getValue() + 1), // symbol@tprel@highera
    VK_PPC_TPREL_HIGHEST(VK_PPC_TPREL_HIGHERA.getValue() + 1), // symbol@tprel@highest
    VK_PPC_TPREL_HIGHESTA(VK_PPC_TPREL_HIGHEST.getValue() + 1), // symbol@tprel@highesta
    VK_PPC_DTPREL_LO(VK_PPC_TPREL_HIGHESTA.getValue() + 1), // symbol@dtprel@l
    VK_PPC_DTPREL_HI(VK_PPC_DTPREL_LO.getValue() + 1), // symbol@dtprel@h
    VK_PPC_DTPREL_HA(VK_PPC_DTPREL_HI.getValue() + 1), // symbol@dtprel@ha
    VK_PPC_DTPREL_HIGHER(VK_PPC_DTPREL_HA.getValue() + 1), // symbol@dtprel@higher
    VK_PPC_DTPREL_HIGHERA(VK_PPC_DTPREL_HIGHER.getValue() + 1), // symbol@dtprel@highera
    VK_PPC_DTPREL_HIGHEST(VK_PPC_DTPREL_HIGHERA.getValue() + 1), // symbol@dtprel@highest
    VK_PPC_DTPREL_HIGHESTA(VK_PPC_DTPREL_HIGHEST.getValue() + 1), // symbol@dtprel@highesta
    VK_PPC_GOT_TPREL(VK_PPC_DTPREL_HIGHESTA.getValue() + 1), // symbol@got@tprel
    VK_PPC_GOT_TPREL_LO(VK_PPC_GOT_TPREL.getValue() + 1), // symbol@got@tprel@l
    VK_PPC_GOT_TPREL_HI(VK_PPC_GOT_TPREL_LO.getValue() + 1), // symbol@got@tprel@h
    VK_PPC_GOT_TPREL_HA(VK_PPC_GOT_TPREL_HI.getValue() + 1), // symbol@got@tprel@ha
    VK_PPC_GOT_DTPREL(VK_PPC_GOT_TPREL_HA.getValue() + 1), // symbol@got@dtprel
    VK_PPC_GOT_DTPREL_LO(VK_PPC_GOT_DTPREL.getValue() + 1), // symbol@got@dtprel@l
    VK_PPC_GOT_DTPREL_HI(VK_PPC_GOT_DTPREL_LO.getValue() + 1), // symbol@got@dtprel@h
    VK_PPC_GOT_DTPREL_HA(VK_PPC_GOT_DTPREL_HI.getValue() + 1), // symbol@got@dtprel@ha
    VK_PPC_TLS(VK_PPC_GOT_DTPREL_HA.getValue() + 1), // symbol@tls
    VK_PPC_GOT_TLSGD(VK_PPC_TLS.getValue() + 1), // symbol@got@tlsgd
    VK_PPC_GOT_TLSGD_LO(VK_PPC_GOT_TLSGD.getValue() + 1), // symbol@got@tlsgd@l
    VK_PPC_GOT_TLSGD_HI(VK_PPC_GOT_TLSGD_LO.getValue() + 1), // symbol@got@tlsgd@h
    VK_PPC_GOT_TLSGD_HA(VK_PPC_GOT_TLSGD_HI.getValue() + 1), // symbol@got@tlsgd@ha
    VK_PPC_TLSGD(VK_PPC_GOT_TLSGD_HA.getValue() + 1), // symbol@tlsgd
    VK_PPC_GOT_TLSLD(VK_PPC_TLSGD.getValue() + 1), // symbol@got@tlsld
    VK_PPC_GOT_TLSLD_LO(VK_PPC_GOT_TLSLD.getValue() + 1), // symbol@got@tlsld@l
    VK_PPC_GOT_TLSLD_HI(VK_PPC_GOT_TLSLD_LO.getValue() + 1), // symbol@got@tlsld@h
    VK_PPC_GOT_TLSLD_HA(VK_PPC_GOT_TLSLD_HI.getValue() + 1), // symbol@got@tlsld@ha
    VK_PPC_TLSLD(VK_PPC_GOT_TLSLD_HA.getValue() + 1), // symbol@tlsld
    VK_PPC_LOCAL(VK_PPC_TLSLD.getValue() + 1), // symbol@local
    
    VK_COFF_IMGREL32(VK_PPC_LOCAL.getValue() + 1), // symbol@imgrel (image-relative)
    
    VK_Hexagon_PCREL(VK_COFF_IMGREL32.getValue() + 1),
    VK_Hexagon_LO16(VK_Hexagon_PCREL.getValue() + 1),
    VK_Hexagon_HI16(VK_Hexagon_LO16.getValue() + 1),
    VK_Hexagon_GPREL(VK_Hexagon_HI16.getValue() + 1),
    VK_Hexagon_GD_GOT(VK_Hexagon_GPREL.getValue() + 1),
    VK_Hexagon_LD_GOT(VK_Hexagon_GD_GOT.getValue() + 1),
    VK_Hexagon_GD_PLT(VK_Hexagon_LD_GOT.getValue() + 1),
    VK_Hexagon_LD_PLT(VK_Hexagon_GD_PLT.getValue() + 1),
    VK_Hexagon_IE(VK_Hexagon_LD_PLT.getValue() + 1),
    VK_Hexagon_IE_GOT(VK_Hexagon_IE.getValue() + 1),
    
    VK_WebAssembly_FUNCTION(VK_Hexagon_IE_GOT.getValue() + 1), // Function table index, rather than virtual addr
    
    VK_TPREL(VK_WebAssembly_FUNCTION.getValue() + 1),
    VK_DTPREL(VK_TPREL.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VariantKind valueOf(/*uint16_t*/char val) {
      VariantKind out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static VariantKind valueOf(int val) {
      VariantKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VariantKind[] VALUES;
      private static final VariantKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VariantKind kind : VariantKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VariantKind[min < 0 ? (1-min) : 0];
        VALUES = new VariantKind[max >= 0 ? (1+max) : 0];
        for (VariantKind kind : VariantKind.values()) {
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

    private final /*uint16_t*/char value;
    private VariantKind(int val) { this.value = (/*uint16_t*/char)val;}
    @Override public final /*uint16_t*/char getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  /// The symbol reference modifier.
  private /*const*/ VariantKind Kind;
  
  /// Specifies how the variant kind should be printed.
  private /*JBIT const unsigned int*/ boolean UseParensForSymbolVariant /*: 1*/;
  
  // FIXME: Remove this bit.
  private /*JBIT const unsigned int*/ boolean HasSubsectionsViaSymbols /*: 1*/;
  
  /// The symbol being referenced.
  private /*const*/ MCSymbol /*P*/ Symbol;
  
  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::MCSymbolRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 157,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 156,
   FQN="llvm::MCSymbolRefExpr::MCSymbolRefExpr", NM="_ZN4llvm15MCSymbolRefExprC1EPKNS_8MCSymbolENS0_11VariantKindEPKNS_9MCAsmInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExprC1EPKNS_8MCSymbolENS0_11VariantKindEPKNS_9MCAsmInfoE")
  //</editor-fold>
  private MCSymbolRefExpr(/*const*/ MCSymbol /*P*/ Symbol, VariantKind Kind, 
      /*const*/ MCAsmInfo /*P*/ MAI) {
    // : MCExpr(MCExpr::SymbolRef), Kind(Kind), UseParensForSymbolVariant(MAI->useParensForSymbolVariant()), HasSubsectionsViaSymbols(MAI->hasSubsectionsViaSymbols()), Symbol(Symbol) 
    //START JInit
    super(MCExpr.ExprKind.SymbolRef);
    this.Kind = Kind;
    this.UseParensForSymbolVariant = MAI.useParensForSymbolVariant();
    this.HasSubsectionsViaSymbols = MAI.hasSubsectionsViaSymbols();
    this.Symbol = Symbol;
    //END JInit
    assert Native.$bool(Symbol);
  }

/*public:*/
  /// \name Construction
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 320,
   FQN="llvm::MCSymbolRefExpr::create", NM="_ZN4llvm15MCSymbolRefExpr6createEPKNS_8MCSymbolERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr6createEPKNS_8MCSymbolERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCSymbolRefExpr /*P*/ create(/*const*/ MCSymbol /*P*/ Symbol, final MCContext /*&*/ Ctx) {
    return MCSymbolRefExpr.create(Symbol, VariantKind.VK_None, Ctx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 166,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 165,
   FQN="llvm::MCSymbolRefExpr::create", NM="_ZN4llvm15MCSymbolRefExpr6createEPKNS_8MCSymbolENS0_11VariantKindERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr6createEPKNS_8MCSymbolENS0_11VariantKindERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCSymbolRefExpr /*P*/ create(/*const*/ MCSymbol /*P*/ Sym, 
        VariantKind Kind, 
        final MCContext /*&*/ Ctx) {
    return /*NEW_EXPR [operator new] NM=_ZnwjRN4llvm9MCContextEj*/
    /*new (Ctx)*/ $new_uint_MCContext_uint(Ctx, (type$ptr<?> New$Mem)->{
        return new MCSymbolRefExpr(Sym, Kind, Ctx.getAsmInfo());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 172,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 171,
   FQN="llvm::MCSymbolRefExpr::create", NM="_ZN4llvm15MCSymbolRefExpr6createENS_9StringRefENS0_11VariantKindERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr6createENS_9StringRefENS0_11VariantKindERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCSymbolRefExpr /*P*/ create(StringRef Name, VariantKind Kind, 
        final MCContext /*&*/ Ctx) {
    return create(Ctx.getOrCreateSymbol(new Twine(Name)), Kind, Ctx);
  }

  
  /// @}
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::getSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 306,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 333,
   FQN="llvm::MCSymbolRefExpr::getSymbol", NM="_ZNK4llvm15MCSymbolRefExpr9getSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm15MCSymbolRefExpr9getSymbolEv")
  //</editor-fold>
  public /*const*/ MCSymbol /*&*/ getSymbol() /*const*/ {
    return $Deref(Symbol);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 308,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 335,
   FQN="llvm::MCSymbolRefExpr::getKind", NM="_ZNK4llvm15MCSymbolRefExpr7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm15MCSymbolRefExpr7getKindEv")
  //</editor-fold>
  public Native.NativeUShortEnum getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::printVariantKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 380,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 405,
   FQN="llvm::MCSymbolRefExpr::printVariantKind", NM="_ZNK4llvm15MCSymbolRefExpr16printVariantKindERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm15MCSymbolRefExpr16printVariantKindERNS_11raw_ostreamE")
  //</editor-fold>
  public void printVariantKind(final raw_ostream /*&*/ OS) /*const*/ {
    if (UseParensForSymbolVariant) {
      OS.$out_char($$LPAREN).$out(MCSymbolRefExpr.getVariantKindName((VariantKind)getKind())).$out_char($$RPAREN);
    } else {
      OS.$out_char($$AT).$out(MCSymbolRefExpr.getVariantKindName((VariantKind)getKind()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::hasSubsectionsViaSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 312,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 339,
   FQN="llvm::MCSymbolRefExpr::hasSubsectionsViaSymbols", NM="_ZNK4llvm15MCSymbolRefExpr24hasSubsectionsViaSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm15MCSymbolRefExpr24hasSubsectionsViaSymbolsEv")
  //</editor-fold>
  public boolean hasSubsectionsViaSymbols() /*const*/ {
    return HasSubsectionsViaSymbols;
  }

  
  /// @}
  /// \name Static Utility Functions
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::getVariantKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 177,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 176,
   FQN="llvm::MCSymbolRefExpr::getVariantKindName", NM="_ZN4llvm15MCSymbolRefExpr18getVariantKindNameENS0_11VariantKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr18getVariantKindNameENS0_11VariantKindE")
  //</editor-fold>
  public static StringRef getVariantKindName(VariantKind Kind) {
    switch (Kind) {
     case VK_Invalid:
      return new StringRef(/*KEEP_STR*/"<<invalid>>");
     case VK_None:
      return new StringRef(/*KEEP_STR*/"<<none>>");
     case VK_DTPOFF:
      return new StringRef(/*KEEP_STR*/"DTPOFF");
     case VK_DTPREL:
      return new StringRef(/*KEEP_STR*/"DTPREL");
     case VK_GOT:
      return new StringRef(/*KEEP_STR*/"GOT");
     case VK_GOTOFF:
      return new StringRef(/*KEEP_STR*/"GOTOFF");
     case VK_GOTREL:
      return new StringRef(/*KEEP_STR*/"GOTREL");
     case VK_GOTPCREL:
      return new StringRef(/*KEEP_STR*/"GOTPCREL");
     case VK_GOTTPOFF:
      return new StringRef(/*KEEP_STR*/"GOTTPOFF");
     case VK_INDNTPOFF:
      return new StringRef(/*KEEP_STR*/"INDNTPOFF");
     case VK_NTPOFF:
      return new StringRef(/*KEEP_STR*/"NTPOFF");
     case VK_GOTNTPOFF:
      return new StringRef(/*KEEP_STR*/"GOTNTPOFF");
     case VK_PLT:
      return new StringRef(/*KEEP_STR*/"PLT");
     case VK_TLSGD:
      return new StringRef(/*KEEP_STR*/"TLSGD");
     case VK_TLSLD:
      return new StringRef(/*KEEP_STR*/"TLSLD");
     case VK_TLSLDM:
      return new StringRef(/*KEEP_STR*/"TLSLDM");
     case VK_TPOFF:
      return new StringRef(/*KEEP_STR*/"TPOFF");
     case VK_TPREL:
      return new StringRef(/*KEEP_STR*/"TPREL");
     case VK_TLSCALL:
      return new StringRef(/*KEEP_STR*/"tlscall");
     case VK_TLSDESC:
      return new StringRef(/*KEEP_STR*/"tlsdesc");
     case VK_TLVP:
      return new StringRef(/*KEEP_STR*/"TLVP");
     case VK_TLVPPAGE:
      return new StringRef(/*KEEP_STR*/"TLVPPAGE");
     case VK_TLVPPAGEOFF:
      return new StringRef(/*KEEP_STR*/"TLVPPAGEOFF");
     case VK_PAGE:
      return new StringRef(/*KEEP_STR*/"PAGE");
     case VK_PAGEOFF:
      return new StringRef(/*KEEP_STR*/"PAGEOFF");
     case VK_GOTPAGE:
      return new StringRef(/*KEEP_STR*/"GOTPAGE");
     case VK_GOTPAGEOFF:
      return new StringRef(/*KEEP_STR*/"GOTPAGEOFF");
     case VK_SECREL:
      return new StringRef(/*KEEP_STR*/"SECREL32");
     case VK_SIZE:
      return new StringRef(/*KEEP_STR*/"SIZE");
     case VK_WEAKREF:
      return new StringRef(/*KEEP_STR*/"WEAKREF");
     case VK_ARM_NONE:
      return new StringRef(/*KEEP_STR*/"none");
     case VK_ARM_GOT_PREL:
      return new StringRef(/*KEEP_STR*/"GOT_PREL");
     case VK_ARM_TARGET1:
      return new StringRef(/*KEEP_STR*/"target1");
     case VK_ARM_TARGET2:
      return new StringRef(/*KEEP_STR*/"target2");
     case VK_ARM_PREL31:
      return new StringRef(/*KEEP_STR*/"prel31");
     case VK_ARM_SBREL:
      return new StringRef(/*KEEP_STR*/"sbrel");
     case VK_ARM_TLSLDO:
      return new StringRef(/*KEEP_STR*/"tlsldo");
     case VK_ARM_TLSDESCSEQ:
      return new StringRef(/*KEEP_STR*/"tlsdescseq");
     case VK_PPC_LO:
      return new StringRef(/*KEEP_STR*/$l);
     case VK_PPC_HI:
      return new StringRef(/*KEEP_STR*/$h);
     case VK_PPC_HA:
      return new StringRef(/*KEEP_STR*/"ha");
     case VK_PPC_HIGHER:
      return new StringRef(/*KEEP_STR*/"higher");
     case VK_PPC_HIGHERA:
      return new StringRef(/*KEEP_STR*/"highera");
     case VK_PPC_HIGHEST:
      return new StringRef(/*KEEP_STR*/"highest");
     case VK_PPC_HIGHESTA:
      return new StringRef(/*KEEP_STR*/"highesta");
     case VK_PPC_GOT_LO:
      return new StringRef(/*KEEP_STR*/"got@l");
     case VK_PPC_GOT_HI:
      return new StringRef(/*KEEP_STR*/"got@h");
     case VK_PPC_GOT_HA:
      return new StringRef(/*KEEP_STR*/"got@ha");
     case VK_PPC_TOCBASE:
      return new StringRef(/*KEEP_STR*/"tocbase");
     case VK_PPC_TOC:
      return new StringRef(/*KEEP_STR*/"toc");
     case VK_PPC_TOC_LO:
      return new StringRef(/*KEEP_STR*/"toc@l");
     case VK_PPC_TOC_HI:
      return new StringRef(/*KEEP_STR*/"toc@h");
     case VK_PPC_TOC_HA:
      return new StringRef(/*KEEP_STR*/"toc@ha");
     case VK_PPC_DTPMOD:
      return new StringRef(/*KEEP_STR*/"dtpmod");
     case VK_PPC_TPREL_LO:
      return new StringRef(/*KEEP_STR*/"tprel@l");
     case VK_PPC_TPREL_HI:
      return new StringRef(/*KEEP_STR*/"tprel@h");
     case VK_PPC_TPREL_HA:
      return new StringRef(/*KEEP_STR*/"tprel@ha");
     case VK_PPC_TPREL_HIGHER:
      return new StringRef(/*KEEP_STR*/"tprel@higher");
     case VK_PPC_TPREL_HIGHERA:
      return new StringRef(/*KEEP_STR*/"tprel@highera");
     case VK_PPC_TPREL_HIGHEST:
      return new StringRef(/*KEEP_STR*/"tprel@highest");
     case VK_PPC_TPREL_HIGHESTA:
      return new StringRef(/*KEEP_STR*/"tprel@highesta");
     case VK_PPC_DTPREL_LO:
      return new StringRef(/*KEEP_STR*/"dtprel@l");
     case VK_PPC_DTPREL_HI:
      return new StringRef(/*KEEP_STR*/"dtprel@h");
     case VK_PPC_DTPREL_HA:
      return new StringRef(/*KEEP_STR*/"dtprel@ha");
     case VK_PPC_DTPREL_HIGHER:
      return new StringRef(/*KEEP_STR*/"dtprel@higher");
     case VK_PPC_DTPREL_HIGHERA:
      return new StringRef(/*KEEP_STR*/"dtprel@highera");
     case VK_PPC_DTPREL_HIGHEST:
      return new StringRef(/*KEEP_STR*/"dtprel@highest");
     case VK_PPC_DTPREL_HIGHESTA:
      return new StringRef(/*KEEP_STR*/"dtprel@highesta");
     case VK_PPC_GOT_TPREL:
      return new StringRef(/*KEEP_STR*/"got@tprel");
     case VK_PPC_GOT_TPREL_LO:
      return new StringRef(/*KEEP_STR*/"got@tprel@l");
     case VK_PPC_GOT_TPREL_HI:
      return new StringRef(/*KEEP_STR*/"got@tprel@h");
     case VK_PPC_GOT_TPREL_HA:
      return new StringRef(/*KEEP_STR*/"got@tprel@ha");
     case VK_PPC_GOT_DTPREL:
      return new StringRef(/*KEEP_STR*/"got@dtprel");
     case VK_PPC_GOT_DTPREL_LO:
      return new StringRef(/*KEEP_STR*/"got@dtprel@l");
     case VK_PPC_GOT_DTPREL_HI:
      return new StringRef(/*KEEP_STR*/"got@dtprel@h");
     case VK_PPC_GOT_DTPREL_HA:
      return new StringRef(/*KEEP_STR*/"got@dtprel@ha");
     case VK_PPC_TLS:
      return new StringRef(/*KEEP_STR*/"tls");
     case VK_PPC_GOT_TLSGD:
      return new StringRef(/*KEEP_STR*/"got@tlsgd");
     case VK_PPC_GOT_TLSGD_LO:
      return new StringRef(/*KEEP_STR*/"got@tlsgd@l");
     case VK_PPC_GOT_TLSGD_HI:
      return new StringRef(/*KEEP_STR*/"got@tlsgd@h");
     case VK_PPC_GOT_TLSGD_HA:
      return new StringRef(/*KEEP_STR*/"got@tlsgd@ha");
     case VK_PPC_TLSGD:
      return new StringRef(/*KEEP_STR*/"tlsgd");
     case VK_PPC_GOT_TLSLD:
      return new StringRef(/*KEEP_STR*/"got@tlsld");
     case VK_PPC_GOT_TLSLD_LO:
      return new StringRef(/*KEEP_STR*/"got@tlsld@l");
     case VK_PPC_GOT_TLSLD_HI:
      return new StringRef(/*KEEP_STR*/"got@tlsld@h");
     case VK_PPC_GOT_TLSLD_HA:
      return new StringRef(/*KEEP_STR*/"got@tlsld@ha");
     case VK_PPC_TLSLD:
      return new StringRef(/*KEEP_STR*/"tlsld");
     case VK_PPC_LOCAL:
      return new StringRef(/*KEEP_STR*/$local);
     case VK_COFF_IMGREL32:
      return new StringRef(/*KEEP_STR*/"IMGREL");
     case VK_Hexagon_PCREL:
      return new StringRef(/*KEEP_STR*/"PCREL");
     case VK_Hexagon_LO16:
      return new StringRef(/*KEEP_STR*/"LO16");
     case VK_Hexagon_HI16:
      return new StringRef(/*KEEP_STR*/"HI16");
     case VK_Hexagon_GPREL:
      return new StringRef(/*KEEP_STR*/"GPREL");
     case VK_Hexagon_GD_GOT:
      return new StringRef(/*KEEP_STR*/"GDGOT");
     case VK_Hexagon_LD_GOT:
      return new StringRef(/*KEEP_STR*/"LDGOT");
     case VK_Hexagon_GD_PLT:
      return new StringRef(/*KEEP_STR*/"GDPLT");
     case VK_Hexagon_LD_PLT:
      return new StringRef(/*KEEP_STR*/"LDPLT");
     case VK_Hexagon_IE:
      return new StringRef(/*KEEP_STR*/"IE");
     case VK_Hexagon_IE_GOT:
      return new StringRef(/*KEEP_STR*/"IEGOT");
     case VK_WebAssembly_FUNCTION:
      return new StringRef(/*KEEP_STR*/"FUNCTION");
    }
    throw new llvm_unreachable("Invalid variant kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::getVariantKindForName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 284,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 310,
   FQN="llvm::MCSymbolRefExpr::getVariantKindForName", NM="_ZN4llvm15MCSymbolRefExpr21getVariantKindForNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr21getVariantKindForNameENS_9StringRefE")
  //</editor-fold>
  public static MCSymbolRefExpr.VariantKind getVariantKindForName(StringRef Name) {
    return new StringSwitch<VariantKind>(new StringRef(Name.lower())).
        Case(/*KEEP_STR*/"dtprel", VariantKind.VK_DTPREL).
        Case(/*KEEP_STR*/"dtpoff", VariantKind.VK_DTPOFF).
        Case(/*KEEP_STR*/"got", VariantKind.VK_GOT).
        Case(/*KEEP_STR*/"gotoff", VariantKind.VK_GOTOFF).
        Case(/*KEEP_STR*/"gotrel", VariantKind.VK_GOTREL).
        Case(/*KEEP_STR*/"gotpcrel", VariantKind.VK_GOTPCREL).
        Case(/*KEEP_STR*/"gottpoff", VariantKind.VK_GOTTPOFF).
        Case(/*KEEP_STR*/"indntpoff", VariantKind.VK_INDNTPOFF).
        Case(/*KEEP_STR*/"ntpoff", VariantKind.VK_NTPOFF).
        Case(/*KEEP_STR*/"gotntpoff", VariantKind.VK_GOTNTPOFF).
        Case(/*KEEP_STR*/"plt", VariantKind.VK_PLT).
        Case(/*KEEP_STR*/"tlscall", VariantKind.VK_TLSCALL).
        Case(/*KEEP_STR*/"tlsdesc", VariantKind.VK_TLSDESC).
        Case(/*KEEP_STR*/"tlsgd", VariantKind.VK_TLSGD).
        Case(/*KEEP_STR*/"tlsld", VariantKind.VK_TLSLD).
        Case(/*KEEP_STR*/"tlsldm", VariantKind.VK_TLSLDM).
        Case(/*KEEP_STR*/"tpoff", VariantKind.VK_TPOFF).
        Case(/*KEEP_STR*/"tprel", VariantKind.VK_TPREL).
        Case(/*KEEP_STR*/"tlvp", VariantKind.VK_TLVP).
        Case(/*KEEP_STR*/"tlvppage", VariantKind.VK_TLVPPAGE).
        Case(/*KEEP_STR*/"tlvppageoff", VariantKind.VK_TLVPPAGEOFF).
        Case(/*KEEP_STR*/"page", VariantKind.VK_PAGE).
        Case(/*KEEP_STR*/"pageoff", VariantKind.VK_PAGEOFF).
        Case(/*KEEP_STR*/"gotpage", VariantKind.VK_GOTPAGE).
        Case(/*KEEP_STR*/"gotpageoff", VariantKind.VK_GOTPAGEOFF).
        Case(/*KEEP_STR*/"imgrel", VariantKind.VK_COFF_IMGREL32).
        Case(/*KEEP_STR*/"secrel32", VariantKind.VK_SECREL).
        Case(/*KEEP_STR*/"size", VariantKind.VK_SIZE).
        Case(/*KEEP_STR*/"l", VariantKind.VK_PPC_LO).
        Case(/*KEEP_STR*/"h", VariantKind.VK_PPC_HI).
        Case(/*KEEP_STR*/"ha", VariantKind.VK_PPC_HA).
        Case(/*KEEP_STR*/"higher", VariantKind.VK_PPC_HIGHER).
        Case(/*KEEP_STR*/"highera", VariantKind.VK_PPC_HIGHERA).
        Case(/*KEEP_STR*/"highest", VariantKind.VK_PPC_HIGHEST).
        Case(/*KEEP_STR*/"highesta", VariantKind.VK_PPC_HIGHESTA).
        Case(/*KEEP_STR*/"got@l", VariantKind.VK_PPC_GOT_LO).
        Case(/*KEEP_STR*/"got@h", VariantKind.VK_PPC_GOT_HI).
        Case(/*KEEP_STR*/"got@ha", VariantKind.VK_PPC_GOT_HA).
        Case(/*KEEP_STR*/"local", VariantKind.VK_PPC_LOCAL).
        Case(/*KEEP_STR*/"tocbase", VariantKind.VK_PPC_TOCBASE).
        Case(/*KEEP_STR*/"toc", VariantKind.VK_PPC_TOC).
        Case(/*KEEP_STR*/"toc@l", VariantKind.VK_PPC_TOC_LO).
        Case(/*KEEP_STR*/"toc@h", VariantKind.VK_PPC_TOC_HI).
        Case(/*KEEP_STR*/"toc@ha", VariantKind.VK_PPC_TOC_HA).
        Case(/*KEEP_STR*/"tls", VariantKind.VK_PPC_TLS).
        Case(/*KEEP_STR*/"dtpmod", VariantKind.VK_PPC_DTPMOD).
        Case(/*KEEP_STR*/"tprel@l", VariantKind.VK_PPC_TPREL_LO).
        Case(/*KEEP_STR*/"tprel@h", VariantKind.VK_PPC_TPREL_HI).
        Case(/*KEEP_STR*/"tprel@ha", VariantKind.VK_PPC_TPREL_HA).
        Case(/*KEEP_STR*/"tprel@higher", VariantKind.VK_PPC_TPREL_HIGHER).
        Case(/*KEEP_STR*/"tprel@highera", VariantKind.VK_PPC_TPREL_HIGHERA).
        Case(/*KEEP_STR*/"tprel@highest", VariantKind.VK_PPC_TPREL_HIGHEST).
        Case(/*KEEP_STR*/"tprel@highesta", VariantKind.VK_PPC_TPREL_HIGHESTA).
        Case(/*KEEP_STR*/"dtprel@l", VariantKind.VK_PPC_DTPREL_LO).
        Case(/*KEEP_STR*/"dtprel@h", VariantKind.VK_PPC_DTPREL_HI).
        Case(/*KEEP_STR*/"dtprel@ha", VariantKind.VK_PPC_DTPREL_HA).
        Case(/*KEEP_STR*/"dtprel@higher", VariantKind.VK_PPC_DTPREL_HIGHER).
        Case(/*KEEP_STR*/"dtprel@highera", VariantKind.VK_PPC_DTPREL_HIGHERA).
        Case(/*KEEP_STR*/"dtprel@highest", VariantKind.VK_PPC_DTPREL_HIGHEST).
        Case(/*KEEP_STR*/"dtprel@highesta", VariantKind.VK_PPC_DTPREL_HIGHESTA).
        Case(/*KEEP_STR*/"got@tprel", VariantKind.VK_PPC_GOT_TPREL).
        Case(/*KEEP_STR*/"got@tprel@l", VariantKind.VK_PPC_GOT_TPREL_LO).
        Case(/*KEEP_STR*/"got@tprel@h", VariantKind.VK_PPC_GOT_TPREL_HI).
        Case(/*KEEP_STR*/"got@tprel@ha", VariantKind.VK_PPC_GOT_TPREL_HA).
        Case(/*KEEP_STR*/"got@dtprel", VariantKind.VK_PPC_GOT_DTPREL).
        Case(/*KEEP_STR*/"got@dtprel@l", VariantKind.VK_PPC_GOT_DTPREL_LO).
        Case(/*KEEP_STR*/"got@dtprel@h", VariantKind.VK_PPC_GOT_DTPREL_HI).
        Case(/*KEEP_STR*/"got@dtprel@ha", VariantKind.VK_PPC_GOT_DTPREL_HA).
        Case(/*KEEP_STR*/"got@tlsgd", VariantKind.VK_PPC_GOT_TLSGD).
        Case(/*KEEP_STR*/"got@tlsgd@l", VariantKind.VK_PPC_GOT_TLSGD_LO).
        Case(/*KEEP_STR*/"got@tlsgd@h", VariantKind.VK_PPC_GOT_TLSGD_HI).
        Case(/*KEEP_STR*/"got@tlsgd@ha", VariantKind.VK_PPC_GOT_TLSGD_HA).
        Case(/*KEEP_STR*/"got@tlsld", VariantKind.VK_PPC_GOT_TLSLD).
        Case(/*KEEP_STR*/"got@tlsld@l", VariantKind.VK_PPC_GOT_TLSLD_LO).
        Case(/*KEEP_STR*/"got@tlsld@h", VariantKind.VK_PPC_GOT_TLSLD_HI).
        Case(/*KEEP_STR*/"got@tlsld@ha", VariantKind.VK_PPC_GOT_TLSLD_HA).
        Case(/*KEEP_STR*/"gdgot", VariantKind.VK_Hexagon_GD_GOT).
        Case(/*KEEP_STR*/"gdplt", VariantKind.VK_Hexagon_GD_PLT).
        Case(/*KEEP_STR*/"iegot", VariantKind.VK_Hexagon_IE_GOT).
        Case(/*KEEP_STR*/"ie", VariantKind.VK_Hexagon_IE).
        Case(/*KEEP_STR*/"ldgot", VariantKind.VK_Hexagon_LD_GOT).
        Case(/*KEEP_STR*/"ldplt", VariantKind.VK_Hexagon_LD_PLT).
        Case(/*KEEP_STR*/"pcrel", VariantKind.VK_Hexagon_PCREL).
        Case(/*KEEP_STR*/"none", VariantKind.VK_ARM_NONE).
        Case(/*KEEP_STR*/"got_prel", VariantKind.VK_ARM_GOT_PREL).
        Case(/*KEEP_STR*/"target1", VariantKind.VK_ARM_TARGET1).
        Case(/*KEEP_STR*/"target2", VariantKind.VK_ARM_TARGET2).
        Case(/*KEEP_STR*/"prel31", VariantKind.VK_ARM_PREL31).
        Case(/*KEEP_STR*/"sbrel", VariantKind.VK_ARM_SBREL).
        Case(/*KEEP_STR*/"tlsldo", VariantKind.VK_ARM_TLSLDO).
        Default(VariantKind.VK_Invalid);
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolRefExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 351,
   FQN="llvm::MCSymbolRefExpr::classof", NM="_ZN4llvm15MCSymbolRefExpr7classofEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm15MCSymbolRefExpr7classofEPKNS_6MCExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCExpr /*P*/ E) {
    return E.getKind() == MCExpr.ExprKind.SymbolRef;
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", UseParensForSymbolVariant=" + UseParensForSymbolVariant // NOI18N
              + ", HasSubsectionsViaSymbols=" + HasSubsectionsViaSymbols // NOI18N
              + ", Symbol=" + Symbol // NOI18N
              + super.toString(); // NOI18N
  }
}
