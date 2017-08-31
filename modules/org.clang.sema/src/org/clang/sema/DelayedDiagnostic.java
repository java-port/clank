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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import java.util.Objects;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;

/// A diagnostic message which has been conditionally emitted pending
/// the complete parsing of the current declaration.
//<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 114,
 FQN="clang::sema::DelayedDiagnostic", NM="_ZN5clang4sema17DelayedDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticE")
//</editor-fold>
public class DelayedDiagnostic implements NativeMoveable<DelayedDiagnostic>, NativePOD<DelayedDiagnostic> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::DDKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 116,
   FQN="clang::sema::DelayedDiagnostic::DDKind", NM="_ZN5clang4sema17DelayedDiagnostic6DDKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic6DDKindE")
  //</editor-fold>
  public enum DDKind implements Native.ComparableLower {
    Deprecation(0),
    Unavailable(Deprecation.getValue() + 1),
    Access(Unavailable.getValue() + 1),
    ForbiddenType(Access.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DDKind valueOf(int val) {
      DDKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DDKind[] VALUES;
      private static final DDKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DDKind kind : DDKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DDKind[min < 0 ? (1-min) : 0];
        VALUES = new DDKind[max >= 0 ? (1+max) : 0];
        for (DDKind kind : DDKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DDKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DDKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DDKind)obj).value);}
    //</editor-fold>
  };
  
  public /*uchar*/byte Kind; // actually a DDKind
  public boolean Triggered;
  
  public SourceLocation Loc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp", line = 58,
   FQN="clang::sema::DelayedDiagnostic::Destroy", NM="_ZN5clang4sema17DelayedDiagnostic7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    switch (/*static_cast*/DDKind.valueOf(Kind)) {
     case Access:
      getAccessData().$destroy();
      break;
     case Deprecation:
     case Unavailable:
      /*delete[]*/Destructors.$destroyArray(Unnamed_field3.DeprecationData.Message);
      break;
     case ForbiddenType:
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::makeAvailability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp", line = 22,
   FQN="clang::sema::DelayedDiagnostic::makeAvailability", NM="_ZN5clang4sema17DelayedDiagnostic16makeAvailabilityENS_4Sema22AvailabilityDiagnosticENS_14SourceLocationEPKNS_9NamedDeclEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic16makeAvailabilityENS_4Sema22AvailabilityDiagnosticENS_14SourceLocationEPKNS_9NamedDeclEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEN4llvm9StringRefEb")
  //</editor-fold>
  public static DelayedDiagnostic makeAvailability(Sema.AvailabilityDiagnostic AD, 
                  SourceLocation Loc, 
                  /*const*/ NamedDecl /*P*/ D, 
                  /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass, 
                  /*const*/ ObjCPropertyDecl /*P*/ ObjCProperty, 
                  StringRef Msg, 
                  boolean ObjCPropertyAccess) {
    DelayedDiagnostic DD/*J*/= new DelayedDiagnostic();
    switch (AD) {
     case AD_Deprecation:
      DD.Kind = (byte) DDKind.Deprecation.getValue();
      break;
     case AD_Unavailable:
      DD.Kind = (byte) DDKind.Unavailable.getValue();
      break;
     case AD_Partial:
      throw new llvm_unreachable("AD_Partial diags should not be delayed");
    }
    DD.Triggered = false;
    DD.Loc.$assign(Loc);
    DD.Unnamed_field3.DeprecationData.Decl = D;
    DD.Unnamed_field3.DeprecationData.UnknownObjCClass = UnknownObjCClass;
    DD.Unnamed_field3.DeprecationData.ObjCProperty = ObjCProperty;
    char$ptr/*char P*/ MessageData = null;
    if ((Msg.size() != 0)) {
      MessageData = create_char$ptr(new$char(Msg.size()));
      memcpy(MessageData, Msg.data(), Msg.size());
    }
    
    DD.Unnamed_field3.DeprecationData.Message = $tryClone(MessageData);
    DD.Unnamed_field3.DeprecationData.MessageLen = Msg.size();
    DD.Unnamed_field3.DeprecationData.ObjCPropertyAccess = ObjCPropertyAccess;
    return DD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::makeAccess">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*new in &AccessData */,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 134,
   FQN="clang::sema::DelayedDiagnostic::makeAccess", NM="_ZN5clang4sema17DelayedDiagnostic10makeAccessENS_14SourceLocationERKNS0_14AccessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic10makeAccessENS_14SourceLocationERKNS0_14AccessedEntityE")
  //</editor-fold>
  public static DelayedDiagnostic makeAccess(SourceLocation Loc, 
            final /*const*/ AccessedEntity /*&*/ Entity) {
    DelayedDiagnostic DD/*J*/= new DelayedDiagnostic();
    DD.Kind = (byte) DDKind.Access.getValue();
    DD.Triggered = false;
    DD.Loc.$assign(Loc);
    DD.Unnamed_field3.AccessData.$assignMove(/*FIXME:NEW_EXPR*//*AddrOf*/ /*DD.getAccessData() =*/ /*new (&DD.getAccessData())*/ new AccessedEntity(Entity));
    return DD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::makeForbiddenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 144,
   FQN="clang::sema::DelayedDiagnostic::makeForbiddenType", NM="_ZN5clang4sema17DelayedDiagnostic17makeForbiddenTypeENS_14SourceLocationEjNS_8QualTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic17makeForbiddenTypeENS_14SourceLocationEjNS_8QualTypeEj")
  //</editor-fold>
  public static DelayedDiagnostic makeForbiddenType(SourceLocation loc, 
                   /*uint*/int diagnostic, 
                   QualType type, 
                   /*uint*/int argument) {
    DelayedDiagnostic DD/*J*/= new DelayedDiagnostic();
    DD.Kind = (byte) DDKind.ForbiddenType.getValue();
    DD.Triggered = false;
    DD.Loc.$assign(loc);
    DD.Unnamed_field3.ForbiddenTypeData.Diagnostic = diagnostic;
    DD.Unnamed_field3.ForbiddenTypeData.OperandType = type.getAsOpaquePtr();
    DD.Unnamed_field3.ForbiddenTypeData.Argument = argument;
    return DD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getAccessData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 158,
   FQN="clang::sema::DelayedDiagnostic::getAccessData", NM="_ZN5clang4sema17DelayedDiagnostic13getAccessDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic13getAccessDataEv")
  //</editor-fold>
  public AccessedEntity /*&*/ getAccessData() {
    assert ($uchar2int(Kind) == DDKind.Access.getValue()) : "Not an access diagnostic.";
    return $Deref(reinterpret_cast(AccessedEntity /*P*/ .class, Unnamed_field3.AccessData));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getAccessData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 162,
   FQN="clang::sema::DelayedDiagnostic::getAccessData", NM="_ZNK5clang4sema17DelayedDiagnostic13getAccessDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic13getAccessDataEv")
  //</editor-fold>
  public /*const*/ AccessedEntity /*&*/ getAccessData$Const() /*const*/ {
    assert ($uchar2int(Kind) == DDKind.Access.getValue()) : "Not an access diagnostic.";
    return $Deref(reinterpret_cast(/*const*/ AccessedEntity /*P*/ .class, Unnamed_field3.AccessData));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getDeprecationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 167,
   FQN="clang::sema::DelayedDiagnostic::getDeprecationDecl", NM="_ZNK5clang4sema17DelayedDiagnostic18getDeprecationDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic18getDeprecationDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getDeprecationDecl() /*const*/ {
    assert (($uchar2int(Kind) == DDKind.Deprecation.getValue() || $uchar2int(Kind) == DDKind.Unavailable.getValue())) : "Not a deprecation diagnostic.";
    return Unnamed_field3.DeprecationData.Decl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getDeprecationMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 173,
   FQN="clang::sema::DelayedDiagnostic::getDeprecationMessage", NM="_ZNK5clang4sema17DelayedDiagnostic21getDeprecationMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic21getDeprecationMessageEv")
  //</editor-fold>
  public StringRef getDeprecationMessage() /*const*/ {
    assert (($uchar2int(Kind) == DDKind.Deprecation.getValue() || $uchar2int(Kind) == DDKind.Unavailable.getValue())) : "Not a deprecation diagnostic.";
    return new StringRef(Unnamed_field3.DeprecationData.Message, 
        Unnamed_field3.DeprecationData.MessageLen);
  }

  
  /// The diagnostic ID to emit.  Used like so:
  ///   Diag(diag.Loc, diag.getForbiddenTypeDiagnostic())
  ///     << diag.getForbiddenTypeOperand()
  ///     << diag.getForbiddenTypeArgument();
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getForbiddenTypeDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 184,
   FQN="clang::sema::DelayedDiagnostic::getForbiddenTypeDiagnostic", NM="_ZNK5clang4sema17DelayedDiagnostic26getForbiddenTypeDiagnosticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic26getForbiddenTypeDiagnosticEv")
  //</editor-fold>
  public /*uint*/int getForbiddenTypeDiagnostic() /*const*/ {
    assert ($uchar2int(Kind) == DDKind.ForbiddenType.getValue()) : "not a forbidden-type diagnostic";
    return Unnamed_field3.ForbiddenTypeData.Diagnostic;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getForbiddenTypeArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 189,
   FQN="clang::sema::DelayedDiagnostic::getForbiddenTypeArgument", NM="_ZNK5clang4sema17DelayedDiagnostic24getForbiddenTypeArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic24getForbiddenTypeArgumentEv")
  //</editor-fold>
  public /*uint*/int getForbiddenTypeArgument() /*const*/ {
    assert ($uchar2int(Kind) == DDKind.ForbiddenType.getValue()) : "not a forbidden-type diagnostic";
    return Unnamed_field3.ForbiddenTypeData.Argument;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getForbiddenTypeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 194,
   FQN="clang::sema::DelayedDiagnostic::getForbiddenTypeOperand", NM="_ZNK5clang4sema17DelayedDiagnostic23getForbiddenTypeOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic23getForbiddenTypeOperandEv")
  //</editor-fold>
  public QualType getForbiddenTypeOperand() /*const*/ {
    assert ($uchar2int(Kind) == DDKind.ForbiddenType.getValue()) : "not a forbidden-type diagnostic";
    return QualType.getFromOpaquePtr(Unnamed_field3.ForbiddenTypeData.OperandType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getUnknownObjCClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 199,
   FQN="clang::sema::DelayedDiagnostic::getUnknownObjCClass", NM="_ZNK5clang4sema17DelayedDiagnostic19getUnknownObjCClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic19getUnknownObjCClassEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getUnknownObjCClass() /*const*/ {
    return Unnamed_field3.DeprecationData.UnknownObjCClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getObjCProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 203,
   FQN="clang::sema::DelayedDiagnostic::getObjCProperty", NM="_ZNK5clang4sema17DelayedDiagnostic15getObjCPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic15getObjCPropertyEv")
  //</editor-fold>
  public /*const*/ ObjCPropertyDecl /*P*/ getObjCProperty() /*const*/ {
    return Unnamed_field3.DeprecationData.ObjCProperty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::getObjCPropertyAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 207,
   FQN="clang::sema::DelayedDiagnostic::getObjCPropertyAccess", NM="_ZNK5clang4sema17DelayedDiagnostic21getObjCPropertyAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema17DelayedDiagnostic21getObjCPropertyAccessEv")
  //</editor-fold>
  public boolean getObjCPropertyAccess() /*const*/ {
    return Unnamed_field3.DeprecationData.ObjCPropertyAccess;
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::DD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 213,
   FQN="clang::sema::DelayedDiagnostic::DD", NM="_ZN5clang4sema17DelayedDiagnostic2DDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic2DDE")
  //</editor-fold>
  private static class/*struct*/ DD {
    public /*const*/ NamedDecl /*P*/ Decl;
    public /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass;
    public /*const*/ ObjCPropertyDecl /*P*/ ObjCProperty;
    public /*const*/char$ptr/*char P*/ Message;
    public /*size_t*/int MessageLen;
    public boolean ObjCPropertyAccess;
    //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::DD::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 213,
     FQN="clang::sema::DelayedDiagnostic::DD::operator=", NM="_ZN5clang4sema17DelayedDiagnostic2DDaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic2DDaSEOS2_")
    //</editor-fold>
    public /*inline*/ DD /*&*/ $assignMove(final DD /*&&*/$Prm0) {
      this.Decl = $Prm0.Decl;
      this.UnknownObjCClass = $Prm0.UnknownObjCClass;
      this.ObjCProperty = $Prm0.ObjCProperty;
      this.Message = $tryClone($Prm0.Message);
      this.MessageLen = $Prm0.MessageLen;
      this.ObjCPropertyAccess = $Prm0.ObjCPropertyAccess;
      return /*Deref*/this;
    }
    
    public /*inline*/ DD /*&*/ $assign(final DD /*&*/$Prm0) {
      this.Decl = $Prm0.Decl;
      this.UnknownObjCClass = $Prm0.UnknownObjCClass;
      this.ObjCProperty = $Prm0.ObjCProperty;
      this.Message = $tryClone($Prm0.Message);
      this.MessageLen = $Prm0.MessageLen;
      this.ObjCPropertyAccess = $Prm0.ObjCPropertyAccess;
      return /*Deref*/this;
    }

    public DD() {
    }

    public DD(/*final*/DD /*&*/$Prm0) {
      this.Decl = $Prm0.Decl;
      this.UnknownObjCClass = $Prm0.UnknownObjCClass;
      this.ObjCProperty = $Prm0.ObjCProperty;
      this.Message = $tryClone($Prm0.Message);
      this.MessageLen = $Prm0.MessageLen;
      this.ObjCPropertyAccess = $Prm0.ObjCPropertyAccess;
    }

    
    @Override public String toString() {
      return "" + "Decl=" + Decl // NOI18N
                + ", UnknownObjCClass=" + UnknownObjCClass // NOI18N
                + ", ObjCProperty=" + ObjCProperty // NOI18N
                + ", Message=" + Message // NOI18N
                + ", MessageLen=" + MessageLen // NOI18N
                + ", ObjCPropertyAccess=" + ObjCPropertyAccess; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::FTD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 222,
   FQN="clang::sema::DelayedDiagnostic::FTD", NM="_ZN5clang4sema17DelayedDiagnostic3FTDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic3FTDE")
  //</editor-fold>
  private static class/*struct*/ FTD {
    public /*uint*/int Diagnostic;
    public /*uint*/int Argument;
    public Object/*void P*/ OperandType;
    //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::FTD::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 222,
     FQN="clang::sema::DelayedDiagnostic::FTD::operator=", NM="_ZN5clang4sema17DelayedDiagnostic3FTDaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnostic3FTDaSEOS2_")
    //</editor-fold>
    public /*inline*/ FTD /*&*/ $assignMove(final FTD /*&&*/$Prm0) {
      this.Diagnostic = $Prm0.Diagnostic;
      this.Argument = $Prm0.Argument;
      this.OperandType = $Prm0.OperandType;
      return /*Deref*/this;
    }

    public /*inline*/ FTD() {
    }

    public /*inline*/ FTD(final FTD /*&*/$Prm0) {
      this.Diagnostic = $Prm0.Diagnostic;
      this.Argument = $Prm0.Argument;
      this.OperandType = $Prm0.OperandType;
    }
    
    public /*inline*/ FTD /*&*/ $assign(final FTD /*&*/$Prm0) {
      this.Diagnostic = $Prm0.Diagnostic;
      this.Argument = $Prm0.Argument;
      this.OperandType = $Prm0.OperandType;
      return /*Deref*/this;
    }
    
    @Override public String toString() {
      return "" + "Diagnostic=" + Diagnostic // NOI18N
                + ", Argument=" + Argument // NOI18N
                + ", OperandType=" + OperandType; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 228,
   FQN="clang::sema::DelayedDiagnostic::(anonymous)", NM="_ZN5clang4sema17DelayedDiagnosticE_Unnamed_union3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticE_Unnamed_union3")
  //</editor-fold>
  private static class/*union*/ Unnamed_union3 implements NativePOD<Unnamed_union3> {
    /// Deprecation
    public  DD DeprecationData;
    public  FTD ForbiddenTypeData;
    
    // JAVA: declare as AccessedEntity field, because used externally as pure memory for this class, see DelayedDiagnostic::makeAccess
    // BUT then when cloned, copied as memory, so we need to introduce special $MemoryCopy in AccessedEntity which copies it's memory as well
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    /// Access control.
    public AccessedEntity /*P*/ AccessData;
    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 228,
     FQN="clang::sema::DelayedDiagnostic::(anonymous union)::", NM="_ZN5clang4sema17DelayedDiagnosticUt_C1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticUt_C1EOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3(JD$Move _dparam, final Unnamed_union3 $Prm0) {
      this.DeprecationData = $Prm0.DeprecationData;
      this.ForbiddenTypeData = $Prm0.ForbiddenTypeData;
      this.AccessData = $Prm0.AccessData;
      $Prm0.DeprecationData = null;
      $Prm0.ForbiddenTypeData = null;
      $Prm0.AccessData = new AccessedEntity();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 228,
     FQN="clang::sema::DelayedDiagnostic::(anonymous union)::operator=", NM="_ZN5clang4sema17DelayedDiagnosticUt_aSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticUt_aSEOS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3 $assignMove(final Unnamed_union3 $Prm0) {
      
      this.DeprecationData.$assignMove($Prm0.DeprecationData);
      $Prm0.DeprecationData = null;
      this.ForbiddenTypeData.$assignMove($Prm0.ForbiddenTypeData);
      $Prm0.ForbiddenTypeData = null;
      this.AccessData = $Prm0.AccessData;
      $Prm0.AccessData = null;
      return /*Deref*/this;
    }
    
    public /*inline*/ Unnamed_union3() {
      this.DeprecationData = new DD();
      this.ForbiddenTypeData = new FTD();
      this.AccessData = new AccessedEntity();
    }
    
    public /*inline*/ Unnamed_union3(final Unnamed_union3 $Prm0) {
      this.DeprecationData = new DD($Prm0.DeprecationData);
      this.ForbiddenTypeData = new FTD($Prm0.ForbiddenTypeData);
      this.AccessData = new AccessedEntity().$MemoryCopy($Prm0.AccessData);
    }
    
    @Override
    public /*inline*/ Unnamed_union3 $assign(final Unnamed_union3 $Prm0) {
      
      this.DeprecationData.$assign($Prm0.DeprecationData);
      
      this.ForbiddenTypeData.$assign($Prm0.ForbiddenTypeData);
      
      this.AccessData.$MemoryCopy($Prm0.AccessData);

      return /*Deref*/this;
    }

    @Override
    public boolean $eq(Unnamed_union3 other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (!Objects.equals(this.DeprecationData, other.DeprecationData)) {
        return false;
      }
      if (!Objects.equals(this.ForbiddenTypeData, other.ForbiddenTypeData)) {
        return false;
      }
      if (!Objects.equals(this.AccessData, other.AccessData)) {
        return false;
      }
      return true;
    }

    @Override
    public Unnamed_union3 clone() {
      return new Unnamed_union3(this);
    }
    
    @Override public String toString() {
      return "" + "DeprecationData=" + DeprecationData // NOI18N
                + ", ForbiddenTypeData=" + ForbiddenTypeData // NOI18N
                + ", AccessData=" + AccessData; // NOI18N
    }
  };
  private Unnamed_union3 Unnamed_field3 = new Unnamed_union3();
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::DelayedDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 114,
   FQN="clang::sema::DelayedDiagnostic::DelayedDiagnostic", NM="_ZN5clang4sema17DelayedDiagnosticC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticC1Ev")
  //</editor-fold>
  public /*inline*/ DelayedDiagnostic() {
    // : Loc() 
    //START JInit
    this.Loc = new SourceLocation();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::DelayedDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 114,
   FQN="clang::sema::DelayedDiagnostic::DelayedDiagnostic", NM="_ZN5clang4sema17DelayedDiagnosticC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticC1EOS1_")
  //</editor-fold>
  public /*inline*/ DelayedDiagnostic(JD$Move _dparam, final DelayedDiagnostic /*&&*/$Prm0) {
    // : Kind(static_cast<DelayedDiagnostic &&>().Kind), Triggered(static_cast<DelayedDiagnostic &&>().Triggered), Loc(static_cast<DelayedDiagnostic &&>().Loc), Unnamed_field3(static_cast<DelayedDiagnostic &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Triggered = $Prm0.Triggered;
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.Unnamed_field3 = new Unnamed_union3(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 114,
   FQN="clang::sema::DelayedDiagnostic::operator=", NM="_ZN5clang4sema17DelayedDiagnosticaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema17DelayedDiagnosticaSEOS1_")
  //</editor-fold>
  public /*inline*/ DelayedDiagnostic /*&*/ $assignMove(final DelayedDiagnostic /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Triggered = $Prm0.Triggered;
    this.Loc.$assignMove($Prm0.Loc);
    this.Unnamed_field3.$assignMove($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnostic::~DelayedDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 114,
   FQN="clang::sema::DelayedDiagnostic::~DelayedDiagnostic", NM="_ZN5clang4sema17DelayedDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN5clang4sema17DelayedDiagnosticD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
  }

  public /*inline*/ DelayedDiagnostic(final DelayedDiagnostic /*&*/$Prm0) {
    // : Kind(static_cast<DelayedDiagnostic &&>().Kind), Triggered(static_cast<DelayedDiagnostic &&>().Triggered), Loc(static_cast<DelayedDiagnostic &&>().Loc), Unnamed_field3(static_cast<DelayedDiagnostic &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Triggered = $Prm0.Triggered;
    this.Loc = new SourceLocation($Prm0.Loc);
    this.Unnamed_field3 = new Unnamed_union3($Prm0.Unnamed_field3);
    //END JInit
  }
  
  public /*inline*/ DelayedDiagnostic /*&*/ $assign(final DelayedDiagnostic /*&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Triggered = $Prm0.Triggered;
    this.Loc.$assign($Prm0.Loc);
    this.Unnamed_field3.$assign($Prm0.Unnamed_field3);
    return /*Deref*/this;
  }

  @Override
  public DelayedDiagnostic clone() {
    return new DelayedDiagnostic(this);
  }

  @Override
  public DelayedDiagnostic move() {
    return new DelayedDiagnostic(JD$Move.INSTANCE, this);
  }

  @Override
  public boolean $eq(DelayedDiagnostic other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.Kind != other.Kind) {
      return false;
    }
    if (this.Triggered != other.Triggered) {
      return false;
    }
    if (this.Loc.$noteq(other.Loc)) {
      return false;
    }
    if (!this.Unnamed_field3.$eq(other.Unnamed_field3)) {
      return false;
    }
    return true;
  }
  
  @Override public String toString() {
    return "" + "Kind=" + DDKind.valueOf($uchar2uint(Kind)) // NOI18N
              + ", Triggered=" + Triggered // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Unnamed_field3=" + Unnamed_field3; // NOI18N
  }
}
